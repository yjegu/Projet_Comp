tree grammar VSLTreeParser;

options {
  language     = Java;
  tokenVocab   = VSLParser;
  ASTLabelType = CommonTree;
}

s [SymbolTable symTab] returns [Code3a code]
  : e=expression[symTab] { code = e.code; }
;

statement [SymbolTable symTab] returns [Code3a code3a]
  : ^(ASSIGN_KW e1=expression[symTab])
    {
      
    }
  | b=block[symTab] {code3a=b;}
;

block [SymbolTable symTab] returns [Code3a code3a]
  : ^(BLOCK il=inst_list[symTab])
    {
      code3a=il;
    }
;

inst_list [SymbolTable symTab] returns [Code3a code3a]
  : 
  statement[symTab]
;

expression [SymbolTable symTab] returns [ExpAttribute expAtt]
  : ^(PLUS e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }

    /* substraction operation */
  | ^(MINUS e1=expression[symTab] e2=expression[symTab])
    {
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }

    /* multiplication operation */
  | ^(MUL e1=expression[symTab] e2=expression[symTab])
    {
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }

    /* division operation */
  | ^(DIV e1=expression[symTab] e2=expression[symTab])
    {
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }

  | pe=primary_exp[symTab] 
    { expAtt = pe; }
;

primary_exp [SymbolTable symTab] returns [ExpAttribute expAtt]
  : INTEGER
    {
      ConstSymbol cs = new ConstSymbol(Integer.parseInt($INTEGER.text));
      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
    }
  | IDENT
    {
      Operand3a id = symTab.lookup($IDENT.text);
      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup($IDENT.text));
    }
;
