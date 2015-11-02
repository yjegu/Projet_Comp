tree grammar VSLTreeParser;

/* Options */
options {
  	language     = Java;
  	tokenVocab   = VSLParser;
  	ASTLabelType = CommonTree;
}

/* Axiom */
s [SymbolTable symTab] returns [Code3a code] 
	:
		e=expression[symTab] 
		{
	 		code = e.code;
		}

	|

		st=statement[symTab]
		{
	  		code = st;
		}
;

/* Instructions */
statement [SymbolTable symTab] returns [Code3a code3a]
  	@init
    {
    	code3a = new Code3a();
    }
  	: 	
  		^(ASSIGN_KW e1=expression[symTab] IDENT 
      		(
        		{
          			code3a = Code3aGenerator.genAffExpr(symTab, e1, $IDENT.text);
        		}
      		)
    	)

  	|

  		b=block[symTab]
    	{
        	code3a = b;
    	}

    |

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

      ^(
        WHILE_KW
        {
          LabelSymbol l_while = SymbDistrib.newLabel();
          LabelSymbol l_end = SymbDistrib.newLabel();
        }

        e=expression[symTab]
        {
          code3a = Code3aGenerator.genWhileStatement(e, l_end);
        }

        st=statement[symTab]
        {
          code3a.append(st);
          code3a.append(Code3aGenerator.genGoTo(l_while));
        }
       )

    |

    	^(
    		PRINT_KW
    		pr=print_list[symTab]
    	 )
    	{
    		code3a = pr;
    	}

    |

    	^(
    		READ_KW
    		r=read_list[symTab]
    	)
    	{
        code3a = r;
    	}
;

/* Block of code */
block [SymbolTable symTab] returns [Code3a code3a]
  	@init
    {
      code3a = new Code3a();
    }
	:
		^(BLOCK 
    	{
      		symTab.enterScope();
    	}

    	d=declaration[symTab] il=inst_list[symTab])
    	
    	{
      		code3a = d;
      		code3a.append(il);
      		symTab.leaveScope();
    	}

  |

  	^(BLOCK il=inst_list[symTab])
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

/* Expressions */
expression [SymbolTable symTab] returns [ExpAttribute expAtt]
  	:
  		/* Addition operation */ 
    	^(PLUS e1=expression[symTab] e2=expression[symTab]) 
    	{ 
	    	Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
	      	VarSymbol temp = SymbDistrib.newTemp();
	      	Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
	      	expAtt = new ExpAttribute(ty, cod, temp);
	    }

  	|

	  	/* Substraction operation */
	    ^(MINUS e1=expression[symTab] e2=expression[symTab])
	    {
	      	Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
	      	VarSymbol temp = SymbDistrib.newTemp();
	      	Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
	      	expAtt = new ExpAttribute(ty, cod, temp);
	    }

  	|

	  	/* Multiplication operation */
	    ^(MUL e1=expression[symTab] e2=expression[symTab])
	    {
			Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
			VarSymbol temp = SymbDistrib.newTemp();
			Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
			expAtt = new ExpAttribute(ty, cod, temp);
	    }

  	|

	  	/* Division operation */
	    ^(DIV e1=expression[symTab] e2=expression[symTab])
	    {
			Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
			VarSymbol temp = SymbDistrib.newTemp();
			Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
			expAtt = new ExpAttribute(ty, cod, temp);
	    }

  	|

	  	/* Unary negation */
	    ^(NEGAT e=expression[symTab])
	    {
			Type ty = TypeCheck.checkUnOp(e.type);
			VarSymbol temp = SymbDistrib.newTemp();
			Code3a cod = Code3aGenerator.genUnOp(Inst3a.TAC.NEG, temp, e);
			expAtt = new ExpAttribute(ty, cod, temp);
	    }

  	|

	  	pe=primary_exp[symTab] 
	    { 
	      	expAtt = pe; 
	    }

;

/* Primary expression */
primary_exp [SymbolTable symTab] returns [ExpAttribute expAtt]
  	:
  		INTEGER
    	{
      		ConstSymbol cs = new ConstSymbol(Integer.parseInt($INTEGER.text));
      		expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
    	}

  	|

  		IDENT
    	{
      		Operand3a id = symTab.lookup($IDENT.text);
      		expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup($IDENT.text));
    	}
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
		TEXT
		{
			code3a = Code3aGenerator.genPrintString($TEXT.text);	
		}

	|

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
		IDENT
		{
			code3a = Code3aGenerator.genReadIdent(symTab, $IDENT.text);
		}
;



/* Declarations */
declaration [SymbolTable symTab] returns [Code3a code3a]
  	@init
    {
    	code3a = new Code3a();
    }
  	: 	^(DECL 
			(value = decl_item[symTab]
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
	  	IDENT 
	  	{
			code3a.append(Code3aGenerator.genDeclVar(symTab, $IDENT.text));
			symTab.print();
	  	}
;
