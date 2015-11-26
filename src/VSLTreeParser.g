tree grammar VSLTreeParser;

/* Options */
options {
  	language     = Java;
  	tokenVocab   = VSLParser;
  	ASTLabelType = CommonTree;
}

/* Axiom */
s [SymbolTable symTab] returns [Code3a code3a] 
	:
		p=program[symTab]
		{
			code3a = p;
		}
;

/* Program */
program [SymbolTable symTab] returns [Code3a code3a]
	@init
	{
		code3a = new Code3a();
	}
	:
		^(
			PROG(
				u=unit[symTab]
				{
					code3a.append(u);
				}
			)+
		)
;

/* Unit (function or prototype) */
unit [SymbolTable symTab] returns [Code3a code3a]
    :
    	/* Function */
    	f=function[symTab]
    	{
    		code3a = f;
    	}

    |

    	/* Prototype */
    	p=proto[symTab]
    	{
    		code3a = p;
    	}
    ;

/* Prototype */
proto [SymbolTable symTab] returns [Code3a code3a]
	:
		^(
			PROTO_KW
			t=type[symTab]
			IDENT
			p=param_list[symTab]
			{
				code3a = Code3aGenerator.genFunctionSignature(symTab, $IDENT.text, t, p, true, $PROTO_KW);
			}
		)
;

/* Function */
function [SymbolTable symTab] returns [Code3a code3a]
	:
		^(
			FUNC_KW
			t=type[symTab]
			IDENT
			p=param_list[symTab]
			{
				code3a = Code3aGenerator.genFunctionSignature(symTab, $IDENT.text, t, p, false, $FUNC_KW);
			}

			^(
				BODY
				st=statement[symTab]
				{
					code3a.append(st);
				}
			)
			{
				symTab.leaveScope();
				code3a.append(Code3aGenerator.genEndFunc());
			}
		)
;

/* Function (or proto) type */
type [SymbolTable symTab] returns [Type typeFunc]
	:
		/* Type INT */
		INT_KW
		{
			typeFunc = Type.INT;
		}

	|
		/* Type VOID */
		VOID_KW
		{
			typeFunc = Type.VOID;
		}
;

/* List of parameters of a function or proto */
param_list [SymbolTable symTab] returns [List<VarSymbol> vars]
	@init
	{
		vars = new ArrayList<VarSymbol>();
	}
	:
		/* One or more parameter(s) */
		^(
			PARAM(
				par=param[symTab]
				{
					vars.add(par);
				}
			)*
		)

	|

		/* No parameter */
		PARAM
;

/* Parameter */
param [SymbolTable symTab] returns [VarSymbol par]
	:
		/* simple parameter (int type) */
		IDENT
		{
			par = Code3aGenerator.genParam(symTab, $IDENT.text);
		}

	|

		/* parameter for array (pointer type) */
		^(
			ARRAY
			IDENT
			{
				par = Code3aGenerator.genArrayParam(symTab, $IDENT.text);
			}
		)
;

/* Instructions */
statement [SymbolTable symTab] returns [Code3a code3a]
	@init
	{
		code3a = new Code3a();
	}
	:
		/* Assignment */
		^(
			ASSIGN_KW
			e1=expression[symTab]
			(
			/* Assignment of an ident */
				(
					IDENT
					{
						code3a = Code3aGenerator.genAffExpr(symTab, e1, $IDENT.text, $ASSIGN_KW);
					}
				)

			|

				/* Assignment of an array item */
				(
					a=array_elem[symTab]
				)
					{
						code3a = e1.code;
						code3a.append(Code3aGenerator.genVarTab(a, e1.place));
					}
			)
		)

  	|

		/* Block */
		b=block[symTab]
		{
			code3a = b;
		}

	|

		/* If condition (with or without else part) */
		^(
			IF_KW
			e1=expression[symTab]
			{
				LabelSymbol l_else = SymbDistrib.newLabel();
				LabelSymbol l_end = SymbDistrib.newLabel();
				code3a = Code3aGenerator.genIfStatement(e1, l_else);
			}

			s1 = statement[symTab]
			{
				code3a.append(s1);
				code3a.append(Code3aGenerator.genGoTo(l_end));
				code3a.append(Code3aGenerator.genLabel(l_else));
			}
			(
				s2 = statement[symTab]
				{
					code3a.append(s2);
				}
			)?
			{
				code3a.append(Code3aGenerator.genLabel(l_end));
			}
		)

	|

		/* While loop */
		^(
			WHILE_KW
			{
				LabelSymbol l_while = SymbDistrib.newLabel();
				LabelSymbol l_end = SymbDistrib.newLabel();
			}

			e=expression[symTab]
			{
				code3a = Code3aGenerator.genLabel(l_while);
				code3a.append(Code3aGenerator.genWhileStatement(e, l_end));
			}

			st=statement[symTab]
			{
				code3a.append(st);
				code3a.append(Code3aGenerator.genGoTo(l_while));
				code3a.append(Code3aGenerator.genLabel(l_end));
			}
		)

	|

		/* Print */
		^(
			PRINT_KW
			pr=print_list[symTab]
		)
		{
			code3a = pr;
		}

	|

		/* Read */
		^(
			READ_KW
			r=read_list[symTab]
		)
		{
			code3a = r;
		}

	|

		/* Return */
		^(
			RETURN_KW
			e=expression[symTab]
			{
				code3a = Code3aGenerator.genReturn(e, $RETURN_KW);
			}
		)

	|

		/* Call with or without argument */
		^(
			FCALL_S
			IDENT
			(
				al=argument_list[symTab]
			)?
			{
				code3a = Code3aGenerator.genFunctionCallInStatement(symTab, $IDENT.text, (argument_list_return) al, $FCALL_S);
			}
		)
;

/* Block of code */
block [SymbolTable symTab] returns [Code3a code3a]
	@init
	{
		code3a = new Code3a();
	}
	:
		/* Declarations + statements */
		^(
			BLOCK 
			{
				symTab.enterScope();
			}
			d=declaration[symTab] il=inst_list[symTab]
		)
		{
			code3a = d;
			code3a.append(il);
			symTab.leaveScope();
		}

	|

		/* Statements only */
		^(
			BLOCK
			il=inst_list[symTab]
		)
		{
			code3a = il;
		}
;

/* Instruction list */
inst_list [SymbolTable symTab] returns [Code3a code3a]
	@init
	{
		code3a = new Code3a();
	}
	:
		^(
			INST(
				il=statement[symTab]
				{
					code3a.append(il);
				}
			)
		+)
;

/* Array element */
array_elem [SymbolTable symTab] returns [ExpArrayAttribute exp]
	:
		^(
			ARELEM 
			IDENT
			e=expression[symTab]
			{
				exp = Code3aGenerator.genArrayElement(symTab, $IDENT.text, e, $ARELEM);
			}
		)
;

/* Expression */
expression [SymbolTable symTab] returns [ExpAttribute expAtt]
	:
		/* Addition operation */ 
		^(
			PLUS
			e1=expression[symTab]
			e2=expression[symTab]
		)
		{
			Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
			VarSymbol temp = SymbDistrib.newTemp();
			Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
			expAtt = new ExpAttribute(ty, cod, temp);
		}

	|

		/* Substraction operation */
		^(
			MINUS
			e1=expression[symTab]
			e2=expression[symTab]
		)
		{
			Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
			VarSymbol temp = SymbDistrib.newTemp();
			Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
			expAtt = new ExpAttribute(ty, cod, temp);
		}

	|

		/* Multiplication operation */
		^(
			MUL
			e1=expression[symTab]
			e2=expression[symTab]
		)
		{
			Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
			VarSymbol temp = SymbDistrib.newTemp();
			Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
			expAtt = new ExpAttribute(ty, cod, temp);
		}

	|

		/* Division operation */
		^(
			DIV
			e1=expression[symTab]
			e2=expression[symTab]
		)
		{
			Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
			VarSymbol temp = SymbDistrib.newTemp();
			Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
			expAtt = new ExpAttribute(ty, cod, temp);
		}

	|

		/* Primary expression */
		pe=primary_exp[symTab] 
		{
			expAtt = pe; 
		}

;

/* Primary expression */
primary_exp [SymbolTable symTab] returns [ExpAttribute expAtt]
	:
		/* Simple integer */
		INTEGER
		{
			ConstSymbol cs = new ConstSymbol(Integer.parseInt($INTEGER.text));
			expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
		}

	|

		/* Ident */
		IDENT
		{
			Operand3a id = symTab.lookup($IDENT.text);
			if(id == null) {
				Errors.unknownIdentifier($IDENT, $IDENT.text, null);
				System.err.println("Compilation terminated");
				System.exit(-1);
			}
			expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup($IDENT.text));
		}

	|

		/* Call */
		^(
			FCALL
			IDENT
			(
				al=argument_list[symTab]
			)?
		)
		{
			expAtt = Code3aGenerator.genFunctionCallInPrimaryExp(symTab, $IDENT.text, (argument_list_return) al, $FCALL);
		}

	|

		/* Array element */
		a=array_elem[symTab]
		{
			expAtt = a.exp;
		}
;

/* List of arguments */
argument_list [SymbolTable symTab] returns [Code3a code, List<Type> args]
	@init
	{
		$code = new Code3a();
		$args = new ArrayList<Type>();
	}
	:
		(
			e=expression[symTab]
			{
				$args.add(e.type);
				$code.append(e.code);
				$code.append(Code3aGenerator.genArg(e.place));
			}
		)+
;

/* Print list instructions */
print_list [SymbolTable symTab] returns [Code3a code3a]
	@init
	{
		code3a = new Code3a();
	}
	:
		(
			pr_list=print_item[symTab]
			{
				code3a.append(pr_list);
			}
		)+
;

/* Print instruction */
print_item [SymbolTable symTab] returns [Code3a code3a]
	:
		/* Print simple text */
		TEXT
		{
			code3a = Code3aGenerator.genPrintString($TEXT.text);	
		}

	|

		/* Print expression */
		e=expression[symTab]
		{
			code3a = Code3aGenerator.genPrintExpr(e);
		}
;

/* Read list instructions */
read_list [SymbolTable symTab] returns [Code3a code3a]
	@init
	{
		code3a = new Code3a();
	}
	:
		(
			rl=read_item[symTab]
			{
				code3a.append(rl);
			}
		)+
;

/* Read instruction */
read_item [SymbolTable symTab] returns [Code3a code3a]
	:
		/* Read simple ident */
		IDENT
		{
			code3a = Code3aGenerator.genReadIdent(symTab, $IDENT.text, $IDENT);
		}

	|

		/* Read array element */
		a=array_elem[symTab]
		{
			code3a = Code3aGenerator.genReadArray(symTab, a);
		}
;



/* Declaration */
declaration [SymbolTable symTab] returns [Code3a code3a]
	@init
	{
		code3a = new Code3a();
	}
	:
		^(
			DECL 
			(
				value = decl_item[symTab]
				{
					code3a.append(value);
				}
			)+
		)
;

/* The real declaration of one precised variable */
decl_item [SymbolTable symTab] returns [Code3a code3a]
	@init
	{
		code3a = new Code3a();
	}
	:
		/* Declare simple ident (int type) */
		IDENT 
		{
			code3a.append(Code3aGenerator.genDeclVar(symTab, $IDENT.text, $IDENT));
		}

	|
		/* Declare array */
		^(
			ARDECL
			IDENT
			INTEGER
			{
				code3a.append(Code3aGenerator.genDeclArray(symTab, $IDENT.text, Integer.parseInt($INTEGER.text), $ARDECL));
			}
		)
;
