import java.util.List;
import org.antlr.runtime.tree.CommonTree;

/**
 * This class implements all the methods for 3a code generation (NOTE: this
 * class must be coded by the student; the methods indicated here can be seen as
 * a suggestion, but are not actually necessary).
 * 
 * @author MLB
 * 
 */
public class Code3aGenerator {

	// Constructor not needed
	private Code3aGenerator() {
	}

	/**
	 * Generates the 3a statement: VAR t
	 **/
	public static Code3a genVar(Operand3a t) {
		Inst3a i = new Inst3a(Inst3a.TAC.VAR, t, null, null);
		return new Code3a(i);
	}
	
	/**
	 * Generate code for arg
	 * @param op the Operand3a which will be the argument
	 * @return the code3a
	 */
	public static Code3a genArg(Operand3a op) {
		// ARG -> arg op
		Inst3a inst = new Inst3a(Inst3a.TAC.ARG, op, null, null);
		Code3a code = new Code3a(inst);
		return code;
	}

	/**
	 * Generate code for call
	 * @param f the Operand3a which will be called
	 * @return the code3a
	 */
	public static Code3a genCall(Operand3a f) {
		// CALL -> call f
		Inst3a inst = new Inst3a(Inst3a.TAC.CALL, null, f, null);
		Code3a code = new Code3a(inst);
		return code;
	}

	/**
	 * Generate code for label
	 * @param label the label to create
	 * @return the code3a
	 */
	public static Code3a genLabel(LabelSymbol lab) {
		// LABEL -> label lab
		Inst3a inst = new Inst3a(Inst3a.TAC.LABEL, lab, null, null);
		Code3a code = new Code3a(inst);
		return code;
	}

	/**
	 * Generate code for goto
	 * @param label the label to goto
	 * @return the code3a
	 */
	public static Code3a genGoTo(LabelSymbol label) {
		// GOTO -> goto label
		Inst3a inst = new Inst3a(Inst3a.TAC.GOTO, label, null, null);
		Code3a code = new Code3a(inst);
		return code;
	}

	/**
	 * Generate code for a binary operation like +, -, * and /
	 * @param op must be a code op: Inst3a.TAC.ADD or SUB or MUL or DIV
	 * @param temp a temporary variable which will store the result
	 * @param exp1 the left term of the binary operation
	 * @param exp2 the right term of the binary operation
	 * @return the code3a
	 */
	public static Code3a genBinOp(Inst3a.TAC op, Operand3a temp, ExpAttribute exp1, ExpAttribute exp2) {
		Code3a code = exp1.code;
		code.append(exp2.code);
		code.append(genVar(temp));
		code.append(new Inst3a(op, temp, exp1.place, exp2.place));
		return code;
	}

	/**
	 * Generate code for a unary operation (negative integers)
	 * @param op must be a code op: Inst3a.TAC.NEG
	 * @param temp a temporary variable which will store the result
	 * @param exp the term of the unary operation
	 * @return the code3a
	 */
	public static Code3a genUnOp(Inst3a.TAC op, Operand3a temp, ExpAttribute exp) {
		Code3a code = exp.code;
		code.append(exp.code);
		code.append(genVar(temp));
		code.append(new Inst3a(op, temp, exp.place, null));
		return code;
	}

	/**
	 * Generate code for affectation statement
	 * @param symTab the symbol table
	 * @param exp the expression for the affectation
	 * @param name the name of the variable which will be affected
	 * @return the code3a
	 */
	public static Code3a genAffExpr(SymbolTable symTab, ExpAttribute exp, String name) {
		Operand3a var = TypeCheck.checkVarDefined(symTab, name);

		if(exp.type.isCompatible(var.type)) { // if variable has correct type
			// COPY -> var = exp.place
			Inst3a inst = new Inst3a(Inst3a.TAC.COPY, var, exp.place, null);
			Code3a code = new Code3a(inst);
			exp.code.append(code);
		}

		else {
			Errors.incompatibleTypes(null, var.type, exp.type, null);
			System.exit(-1);
		}
		return exp.code;
	}

	/**
	 * Generate code for variable declaration
	 * @param symTab the symbol table
	 * @param name the name of the variable which will be defined
	 * @return the code3a
	 */
	public static Code3a genDeclVar(SymbolTable symTab, String name) {
		Operand3a var = symTab.lookup(name);
		Code3a code = null;

		if(var != null) { // if the variable already exist
			System.err.println("Error, the variable " + name + " has already been declared");
			System.exit(-1);
		}

		else {
			// Create a VarSymbol of type int with a given name
			var = new VarSymbol(Type.INT, name, symTab.getScope());
			
			// Insert the variable in the symbol table
			symTab.insert(name, var);

			// Generate code3a
			code = genVar(var);
		}

		return code;
	}

	/**
	 * Generate code for if statement
	 * @param exp the expression to evaluate in the if condition
	 * @param label the label to jump to
	 * @return the code3a
	 */
	public static Code3a genIfStatement(ExpAttribute exp, LabelSymbol label) {
		Code3a code = exp.code;

		// IFZ -> ifz exp.place goto label
		code.append(new Inst3a(Inst3a.TAC.IFZ, exp.place, label, null));
		return code;
	}

	/**
	 * Generate code for while statement
	 * @param exp the expression to evaluate in the while condition
	 * @param label the label to jump to
	 * @return the code3a
	 */
	public static Code3a genWhileStatement(ExpAttribute exp, LabelSymbol label) {
		Code3a code = exp.code;
		code.append(new Inst3a(Inst3a.TAC.IFNZ, exp.place, label, null));
		return code;
	}

	/**
	 * Generate code for print instruction (String only)
	 * @param text the text to print
	 * @return the code3a
	 */
	public static Code3a genPrintString(String text) {
		LabelSymbol printString = SymbDistrib.builtinPrintS;
		Data3a data = new Data3a(text);
		Code3a code = Code3aGenerator.genArg(data.getLabel());
		code.appendData(data);
		code.append(Code3aGenerator.genCall(printString));
		return code;
	}

	/**
	 * Generate code for print instruction (expressions only)
	 * @param exp the expression to print
	 * @return the code3a
	 */
	public static Code3a genPrintExpr(ExpAttribute exp) {
		if(!(TypeCheck.checkTypeInt(exp.type))) {
			System.err.println("The result of expression to print is not an integer");
			System.exit(-1);
		}

		LabelSymbol printExpr = SymbDistrib.builtinPrintN;
		Code3a code = exp.code;
		code.append(Code3aGenerator.genArg(exp.place));
		code.append(Code3aGenerator.genCall(printExpr));
		return code;

	}

	/**
	 * Generate code for read instruction (ident only)
	 * @param symTab the symbol table
	 * @param name the name of the variable which will be read
	 * @return the code3a
	 */
	public static Code3a genReadIdent(SymbolTable symTab, String name) {
		Code3a code = null;
		Operand3a ident = symTab.lookup(name);
		LabelSymbol readIdent = SymbDistrib.builtinRead;
		if(ident == null) {
			System.err.println("Error, the variable " + name + " does not exist");
			System.exit(-1);
		}

		else {
			code = new Code3a(new Inst3a(Inst3a.TAC.CALL, ident, readIdent, null));
		}
		return code;
	}

	public static Code3a genBeginFunc() {
		Inst3a inst = new Inst3a(Inst3a.TAC.BEGINFUNC, null, null, null);
		Code3a code = new Code3a(inst);
		return code;
	}

	public static Code3a genEndFunc() {
		Inst3a inst = new Inst3a(Inst3a.TAC.ENDFUNC, null, null, null);
		Code3a code = new Code3a(inst);
		return code;
	}

	public static VarSymbol genParam(SymbolTable symTab, String name) {
		// Create a VarSymbol of type int with a given name
			VarSymbol var = new VarSymbol(Type.INT, name, symTab.getScope());

			// Set the locale variable as a parameter
			var.setParam();

			return var;
	}

	public static Code3a genReturn(ExpAttribute exp) {
		Code3a code = null;
		if(exp.place.isConstInteger() || exp.place.isVarInteger()) {
			Inst3a inst = new Inst3a(Inst3a.TAC.RETURN, exp.place, null, null);
			code = new Code3a(inst);
		}

		else {
			Errors.miscError(null, "Cannot return in function :\nFound:" + exp.type);
			System.exit(-1);
		}

		return code;
	}

	public static Code3a genFunctionSignature(SymbolTable symTab, String name, Type returnType, List<VarSymbol> args, boolean proto) {
		Operand3a function = symTab.lookup(name);
		Code3a code = null;
		if(function != null) {
			FunctionType type = (FunctionType) function.type;
			if(!type.prototype) {
				Errors.redefinedIdentifier(null, name, "duplicate definition of function");
				System.exit(-1);
			}

			if(!type.getReturnType().equals(returnType)) {
				Errors.incompatibleTypes(null, type.getReturnType(), returnType, null);
				System.exit(-1);
			}

			if(args.size() != type.getArguments().size()) {
				Errors.miscError(null, "Wrong number of arguments : \nExpected : " + type.getArguments().size() + "\nFound : " + args.size());
				System.exit(-1);
			}

			for(int i = 0; i < args.size(); i++) {
				if(!((type.getArguments().get(i)) == ((Operand3a) (args.get(i))).type)) {
				//if(!(type.getArguments().get(i).equals(args.get(i)))) {
					Errors.incompatibleTypes(null, args.get(i), type.getArguments().get(i), null);
					System.exit(-1);
				}
			}
		}

		LabelSymbol l_func = new LabelSymbol(name);
		FunctionType type = new FunctionType(returnType, proto);
		for(VarSymbol var : args) {
			type.extend(var.type);
		}
		FunctionSymbol fun = new FunctionSymbol(l_func, type);

		if(symTab.lookup(name) == null) {
			symTab.insert(name, fun);
		}
		else {
			FunctionType newType = (FunctionType) (symTab.lookup(name).type);
			newType.prototype = false;
		}

		if(!proto) {
			code = Code3aGenerator.genLabel(l_func);
			code.append(Code3aGenerator.genBeginFunc());
			symTab.enterScope();
			for(VarSymbol var : args) {
				Operand3a op = symTab.lookup(var.name);
				if(op != null && op.getScope() == symTab.getScope()) { // if the variable already exist
					Errors.redefinedIdentifier(null, name, "duplicate declaration of parameter");
					System.exit(-1);
				}

				else {
					// Insert the variable in the symbol table
					symTab.insert(var.name, var);

					// Generate code3a
					code.append(genVar(var));
				}
			}
		}

		else {
			for(VarSymbol var : args) {
				Operand3a op = symTab.lookup(var.name);
				if(op != null && op.getScope() == symTab.getScope()) { // if the variable already exist
					System.out.println(op);
					Errors.redefinedIdentifier(null, name, "duplicate declaration of parameter");
					System.exit(-1);
				}
			}
		}

		return code;
	}
} // Code3aGenerator ***