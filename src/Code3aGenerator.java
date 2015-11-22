import java.util.List;
import java.util.ArrayList;
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
	 * Generate code for var
	 * @param op the Operand3a which will be the argument
	 * @return the code3a
	 */
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

	public static Code3a genCallForReturn(Operand3a r, Operand3a f) {
		// CALL -> r = call f
		Inst3a inst = new Inst3a(Inst3a.TAC.CALL, r, f, null);
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

	public static Code3a genTabVar(VarSymbol var, Operand3a op, ExpAttribute exp) {
		// TABVAR -> var = op[exp.place]
		Inst3a inst = new Inst3a(Inst3a.TAC.TABVAR, var, op, exp.place);
		Code3a code = new Code3a(inst);
		return code;
	}

	public static Code3a genVarTab(ExpArrayAttribute array, Operand3a op) {
		// VARTAB -> ...
		Inst3a inst = new Inst3a(Inst3a.TAC.VARTAB, array.place, array.i.place, op);
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
	public static Code3a genAffExpr(SymbolTable symTab, ExpAttribute exp, String name, CommonTree token) {
		Operand3a var = TypeCheck.checkVarDefined(symTab, name, token);

		if(var.type.isCompatible(exp.place.type) || exp.place.type.equals(Type.I_CONST)) { // if variable has correct type
			// COPY -> var = exp.place
			Inst3a inst = new Inst3a(Inst3a.TAC.COPY, var, exp.place, null);
			Code3a code = new Code3a(inst);
			exp.code.append(code);
		}

		else {
			Errors.incompatibleTypes(token, var.type, exp.place.type, null);
			System.exit(-1);
		}
		return exp.code;
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
	public static Code3a genReadIdent(SymbolTable symTab, String name, CommonTree token) {
		Code3a code = null;
		Operand3a ident = TypeCheck.checkVarDefined(symTab, name, token);
		LabelSymbol readIdent = SymbDistrib.builtinRead;
		code = genCallForReturn(ident, readIdent);
		return code;
	}

	public static Code3a genReadArray(SymbolTable symTab, ExpArrayAttribute array) {
		Code3a code = null;
		Operand3a ident = TypeCheck.checkVarDefined(symTab, array.place.getName3a(), null);
		LabelSymbol readArray = SymbDistrib.builtinRead;
		code = genCallForReturn(ident, readArray);
		return code;
	}

	/**
	 * Generate code for variable declaration
	 * @param symTab the symbol table
	 * @param name the name of the variable which will be defined
	 * @return the code3a
	 */
	public static Code3a genDeclVar(SymbolTable symTab, String name, CommonTree token) {
		Code3a code = null;
		Operand3a var = symTab.lookup(name);

		// If the variable has already been declared
		if(var != null && var.getScope() == symTab.getScope()) {
			Errors.redefinedIdentifier(token, name, null);
			System.exit(-1);
		}
		
		// Create a VarSymbol of type int with a given name
		var = new VarSymbol(Type.INT, name, symTab.getScope());
		
		// Insert the variable in the symbol table
		symTab.insert(name, var);

		// Generate code3a
		code = genVar(var);

		System.out.println("symTab after declaring variable " + name + " :");
		symTab.print();

		return code;
	}

	public static Code3a genDeclArray(SymbolTable symTab, String name, int size, CommonTree token) {
		Code3a code = null;
		Operand3a var = symTab.lookup(name);

		// If the variable has already been declared
		if(var != null && var.getScope() == symTab.getScope()) {
			Errors.redefinedIdentifier(token, name, null);
			System.exit(-1);
		}

		ArrayType arrayType = new ArrayType(Type.INT, size);
		
		// Create a VarSymbol of type int with a given name
		var = new VarSymbol(arrayType, name, symTab.getScope());
		
		// Insert the variable in the symbol table
		symTab.insert(name, var);

		// Generate code3a
		code = genVar(var);

		System.out.println("symTab after declaring variable " + name + " :");
		symTab.print();

		return code;
	}

	public static ExpArrayAttribute genArrayElement(SymbolTable symTab, String name, ExpAttribute exp, CommonTree token) {
		Operand3a array = TypeCheck.checkVarDefined(symTab, name, token);

		if(!array.isArray()) {
			Errors.miscError(token, "The variable " + name + " is not an array");
			System.exit(-1);
		}

		VarSymbol var = SymbDistrib.newTemp();
		Code3a code = genVar(var);
		code.append(genTabVar(var, array, exp));
		ExpAttribute e = new ExpAttribute(array.type, code, var);
		return new ExpArrayAttribute(array, exp, e);

	}

	/**
	 * Generate code for marker beginfunc
	 * @return the code3a
	 */
	public static Code3a genBeginFunc() {
		Inst3a inst = new Inst3a(Inst3a.TAC.BEGINFUNC, null, null, null);
		Code3a code = new Code3a(inst);
		return code;
	}

	/**
	 * Generate code for marker endfunc
	 * @return the code3a
	 */
	public static Code3a genEndFunc() {
		Inst3a inst = new Inst3a(Inst3a.TAC.ENDFUNC, null, null, null);
		Code3a code = new Code3a(inst);
		return code;
	}
	
	/**
	 * Generate a VarSymbol of type INT (which will become a parameter of a function) with a specified name
	 * @param symTab the Symbol Table which just allows to know its scope
	 * @param name the variable name
	 * @return a VarSymbol
	 */
	public static VarSymbol genParam(SymbolTable symTab, String name) {
		// Create a VarSymbol of type int with a given name
		VarSymbol var = new VarSymbol(Type.INT, name, symTab.getScope());

		// Set the locale variable as a parameter
		var.setParam();

		return var;
	}

	/**
	 * Generate a VarSymbol of type POINTER (which will become a parameter of a function) with a specified name
	 * @param symTab the Symbol Table which just allows to know its scope
	 * @param name the variable name
	 * @return a VarSymbol
	 */
	public static VarSymbol genArrayParam(SymbolTable symTab, String name) {
		// Create a VarSymbol of type pointer, because it's an array, with a given name
		VarSymbol var = new VarSymbol(Type.POINTER, name, symTab.getScope());

		// Set the locale variable as a parameter
		var.setParam();

		return var;
	}
	
	/**
	 * Generate code for return (function)
	 * @param exp the expression (or value) to return
	 * @return the code3a
	 */
	public static Code3a genReturn(ExpAttribute exp, CommonTree token) {
		Code3a code = null;
		if(exp.place.isConstInteger() || exp.place.isVarInteger()) {
			code = exp.code;
			Inst3a inst = new Inst3a(Inst3a.TAC.RETURN, exp.place, null, null);
			code.append(inst);
		}

		else {
			Errors.miscError(token, "Cannot return in function :\nFound:" + exp.type);
			System.exit(-1);
		}

		return code;
	}

	/**
	 * Generate the header of a function if :\n
	 * <ul>
	 * <li>It's a function without prototype
	 * <li>Just a prototype
	 * <li>Or a function which have been defined previously in prototype
	 * </ul> 
	 */
	public static Code3a genFunctionSignature(SymbolTable symTab, String name, Type returnType, List<VarSymbol> args, boolean proto, CommonTree token) {
		// Search if the function is in symTab
		Operand3a function = symTab.lookup(name);
		Code3a code = null;
		
		// If this function is already in symTab (by its prototype in the good case)
		if(function != null) {

			// Getting type of the function
			FunctionType type = (FunctionType) function.type;
			
			// If the function in symTab is declared as function and not as prototype
			if(!type.prototype) {
				// Sending error
				Errors.redefinedIdentifier(token, name, "duplicate definition of function");
				System.exit(-1);
			}

			// If the type found of the function is not the same as in symTab
			if(!type.getReturnType().equals(returnType)) {
				// Sending error
				Errors.incompatibleTypes(token, type.getReturnType(), returnType, null);
				System.exit(-1);
			}

			// If the number of arguments found is not the same as in symTab
			if(args.size() != type.getArguments().size()) {
				// Sending error
				Errors.miscError(token, "Wrong number of arguments : \nExpected : " + type.getArguments().size() + "\nFound : " + args.size());
				System.exit(-1);
			}

			// For each arguments we check if the type found is the same as in symTab
			for(int i = 0; i < args.size(); i++) {
				if(!((type.getArguments().get(i)) == ((Operand3a) (args.get(i))).type)) {
					// Sending error
					Errors.incompatibleTypes(token, args.get(i), type.getArguments().get(i), null);
					System.exit(-1);
				}
			}
		}

		// Create LabelSymbol to build the function type
		LabelSymbol l_func = new LabelSymbol(name);

		// Create the FunctionType for a function or a prototype
		FunctionType type = new FunctionType(returnType, proto);

		// We extend the type of the function or prototype when we found an argument for this function/prototype
		for(VarSymbol var : args) {
			type.extend(var.type);
		}

		// Create the FunctionSymbol with the label and the type built previously
		FunctionSymbol fun = new FunctionSymbol(l_func, type);

		// If the function is not already on symTab then we add it
		if(symTab.lookup(name) == null) {
			symTab.insert(name, fun);
		}

		// Otherwise we set the functionType and also the boolean prototype of this function to false
		else {
			FunctionType newType = (FunctionType) (symTab.lookup(name).type);
			newType.prototype = false;
		}

		// If it's not a prototype
		if(!proto) {

			// Generate label of the function
			code = Code3aGenerator.genLabel(l_func);

			// Generate 3a beginfunc
			code.append(Code3aGenerator.genBeginFunc());

			// It's a function so we must set up the scope
			symTab.enterScope();

			// For each argument of the function, we check if this variable has not been already declared in the same scope
			for(VarSymbol var : args) {
				
				// Search parameter in symTab
				Operand3a op = symTab.lookup(var.name);
				
				if(op != null && op.getScope() == symTab.getScope()) {
					// Sending error
					Errors.redefinedIdentifier(token, name, "duplicate declaration of parameter");
					System.exit(-1);
				}

				else {
					// Insert the variable in symTab
					symTab.insert(var.name, var);

					// Generate 3a code for var
					code.append(genVar(var));
				}
			}
			System.out.println("symTab after declaring function " + name + " :");
			symTab.print();
		}

		// In the case it's a prototype
		else {

			// For each argument of the function, we check if this variable has not been already declared in the same scope
			for(VarSymbol var : args) {

				// Search parameter in symTab
				Operand3a op = symTab.lookup(var.name);

				if(op != null && op.getScope() == symTab.getScope()) {
					// Sending error
					Errors.redefinedIdentifier(token, name, "duplicate declaration of parameter");
					System.exit(-1);
				}
			}
			System.out.println("symTab after declaring prototype " + name + " :");
			symTab.print();
		}

		return code;
	}

	/**
	 * Generates code3a for calling function in a primary expression
	 * It uses VSLTreeParser.argument_list_return type because the return type of the rule argument_list is a Code3a and a List of Type object
	 * @param symTab the SymbolTable
	 * @param name the function name to be called
	 * @param args the arguments associated to this function
	 * @param token the node of the CommonTree used for errors
	 * @return an ExpAttribute
	 */
	public static ExpAttribute genFunctionCallInPrimaryExp(SymbolTable symTab, String name, VSLTreeParser.argument_list_return foundArgs, CommonTree token) {
		ExpAttribute exp = null;
		Operand3a function = TypeCheck.checkVarDefined(symTab, name, token);

		if(((FunctionType) function.type).getReturnType().equals(Type.VOID)) {
			Errors.miscError(token, "The function " + name + " with VOID return type cannot be applied to a primary expression");
			System.exit(-1);
		}

		List<Type> expectedArgs = ((FunctionType) function.type).getArguments();

		if((foundArgs == null && expectedArgs == null) ||
			(foundArgs == null && expectedArgs.size() == 0) ||
			(foundArgs != null && foundArgs.args.size() == expectedArgs.size())) {

			for (int i = 0; i < expectedArgs.size(); i++) {
				Type expectedArgType = expectedArgs.get(i);
				Type foundArgType = foundArgs.args.get(i);

				if(expectedArgType != foundArgType) {
					Errors.incompatibleTypes(token, expectedArgType, foundArgType, "Location : Argument " + i + " of function " + name);
					System.exit(-1);
				}
			}

			Type t = function.type;
			VarSymbol v = SymbDistrib.newTemp();
			Code3a code = genVar(v);

			if(foundArgs != null) {
				code.append(foundArgs.code);
			}

			code.append(genCallForReturn(v, function));
			exp = new ExpAttribute(t, code, v);
		}

		else {
			Errors.miscError(token, "Bad number of arguments :\nRequired: " + expectedArgs.size() + "\nFound: " + foundArgs.args.size());
			System.exit(-1);
		}

		return exp;
	}

	/**
	 * Generates code3a for calling function in a statement
	 * It uses VSLTreeParser.argument_list_return type because the return type of the rule argument_list is a Code3a and a List of Type object
	 * @param symTab the SymbolTable
	 * @param name the function name to be called
	 * @param args the arguments associated to this function
	 * @param token the node of the CommonTree used for errors
	 * @return an ExpAttribute
	 */
	public static Code3a genFunctionCallInStatement(SymbolTable symTab, String name, VSLTreeParser.argument_list_return foundArgs, CommonTree token) {
		Code3a code = null;
		Operand3a function = TypeCheck.checkVarDefined(symTab, name, token);

		List<Type> expectedArgs = ((FunctionType) function.type).getArguments();

		if((foundArgs == null && expectedArgs == null) ||
			(foundArgs == null && expectedArgs.size() == 0) ||
			(foundArgs != null && foundArgs.args.size() == expectedArgs.size())) {

			for (int i = 0; i < expectedArgs.size(); i++) {
				Type expectedArgType = expectedArgs.get(i);
				Type foundArgType = foundArgs.args.get(i);

				if(expectedArgType != foundArgType) {
					Errors.incompatibleTypes(token, expectedArgType, foundArgType, "Location : Argument " + i + " of function " + name);
					System.exit(-1);
				}
			}

			code = new Code3a();

			if(foundArgs != null) {
				code.append(foundArgs.code);
			}

			code.append(genCall(function));
		}

		else {
			Errors.miscError(token, "Bad number of arguments :\nRequired: " + expectedArgs.size() + "\nFound: " + foundArgs.args.size());
			System.exit(-1);
		}

		return code;
	}
} // Code3aGenerator ***