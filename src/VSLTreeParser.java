// $ANTLR 3.5 ./src/VSLTreeParser.g 2015-11-22 11:44:12

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class VSLTreeParser extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASCII", "ASSIGN_KW", "COM", "COMMENT", 
		"DIGIT", "DIV", "DO_KW", "ELSE_KW", "FI_KW", "FUNC_KW", "IDENT", "IF_KW", 
		"INTEGER", "INT_KW", "LB", "LC", "LETTER", "LP", "MINUS", "MUL", "OD_KW", 
		"PLUS", "PRINT_KW", "PROTO_KW", "RB", "RC", "READ_KW", "RETURN_KW", "RP", 
		"TEXT", "THEN_KW", "VOID_KW", "WHILE_KW", "WS", "ARDECL", "ARELEM", "ARRAY", 
		"BLOCK", "BODY", "DECL", "FCALL", "FCALL_S", "INST", "NEGAT", "PARAM", 
		"PROG"
	};
	public static final int EOF=-1;
	public static final int ASCII=4;
	public static final int ASSIGN_KW=5;
	public static final int COM=6;
	public static final int COMMENT=7;
	public static final int DIGIT=8;
	public static final int DIV=9;
	public static final int DO_KW=10;
	public static final int ELSE_KW=11;
	public static final int FI_KW=12;
	public static final int FUNC_KW=13;
	public static final int IDENT=14;
	public static final int IF_KW=15;
	public static final int INTEGER=16;
	public static final int INT_KW=17;
	public static final int LB=18;
	public static final int LC=19;
	public static final int LETTER=20;
	public static final int LP=21;
	public static final int MINUS=22;
	public static final int MUL=23;
	public static final int OD_KW=24;
	public static final int PLUS=25;
	public static final int PRINT_KW=26;
	public static final int PROTO_KW=27;
	public static final int RB=28;
	public static final int RC=29;
	public static final int READ_KW=30;
	public static final int RETURN_KW=31;
	public static final int RP=32;
	public static final int TEXT=33;
	public static final int THEN_KW=34;
	public static final int VOID_KW=35;
	public static final int WHILE_KW=36;
	public static final int WS=37;
	public static final int ARDECL=38;
	public static final int ARELEM=39;
	public static final int ARRAY=40;
	public static final int BLOCK=41;
	public static final int BODY=42;
	public static final int DECL=43;
	public static final int FCALL=44;
	public static final int FCALL_S=45;
	public static final int INST=46;
	public static final int NEGAT=47;
	public static final int PARAM=48;
	public static final int PROG=49;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public VSLTreeParser(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public VSLTreeParser(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return VSLTreeParser.tokenNames; }
	@Override public String getGrammarFileName() { return "./src/VSLTreeParser.g"; }



	// $ANTLR start "s"
	// ./src/VSLTreeParser.g:11:1: s[SymbolTable symTab] returns [Code3a code3a] : p= program[symTab] ;
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a p =null;

		try {
			// ./src/VSLTreeParser.g:12:2: (p= program[symTab] )
			// ./src/VSLTreeParser.g:13:3: p= program[symTab]
			{
			pushFollow(FOLLOW_program_in_s69);
			p=program(symTab);
			state._fsp--;


						code3a = p;
						System.out.println("symTab at the end of the program :");
						symTab.print();
					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "s"



	// $ANTLR start "program"
	// ./src/VSLTreeParser.g:22:1: program[SymbolTable symTab] returns [Code3a code3a] : ^( PROG (u= unit[symTab] )+ ) ;
	public final Code3a program(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a u =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:27:2: ( ^( PROG (u= unit[symTab] )+ ) )
			// ./src/VSLTreeParser.g:28:3: ^( PROG (u= unit[symTab] )+ )
			{
			match(input,PROG,FOLLOW_PROG_in_program106); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:29:8: (u= unit[symTab] )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==FUNC_KW||LA1_0==PROTO_KW) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// ./src/VSLTreeParser.g:30:5: u= unit[symTab]
					{
					pushFollow(FOLLOW_unit_in_program115);
					u=unit(symTab);
					state._fsp--;


										code3a.append(u);
									
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "program"



	// $ANTLR start "unit"
	// ./src/VSLTreeParser.g:39:1: unit[SymbolTable symTab] returns [Code3a code3a] : (f= function[symTab] |p= proto[symTab] );
	public final Code3a unit(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a f =null;
		Code3a p =null;

		try {
			// ./src/VSLTreeParser.g:40:5: (f= function[symTab] |p= proto[symTab] )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==FUNC_KW) ) {
				alt2=1;
			}
			else if ( (LA2_0==PROTO_KW) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// ./src/VSLTreeParser.g:42:6: f= function[symTab]
					{
					pushFollow(FOLLOW_function_in_unit167);
					f=function(symTab);
					state._fsp--;


					    		code3a = f;
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:50:6: p= proto[symTab]
					{
					pushFollow(FOLLOW_proto_in_unit199);
					p=proto(symTab);
					state._fsp--;


					    		code3a = p;
					    	
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "unit"



	// $ANTLR start "proto"
	// ./src/VSLTreeParser.g:57:1: proto[SymbolTable symTab] returns [Code3a code3a] : ^( PROTO_KW t= type[symTab] IDENT p= param_list[symTab] ) ;
	public final Code3a proto(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT1=null;
		CommonTree PROTO_KW2=null;
		Type t =null;
		List<VarSymbol> p =null;

		try {
			// ./src/VSLTreeParser.g:58:2: ( ^( PROTO_KW t= type[symTab] IDENT p= param_list[symTab] ) )
			// ./src/VSLTreeParser.g:59:3: ^( PROTO_KW t= type[symTab] IDENT p= param_list[symTab] )
			{
			PROTO_KW2=(CommonTree)match(input,PROTO_KW,FOLLOW_PROTO_KW_in_proto236); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_proto243);
			t=type(symTab);
			state._fsp--;

			IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_proto249); 
			pushFollow(FOLLOW_param_list_in_proto256);
			p=param_list(symTab);
			state._fsp--;


							code3a = Code3aGenerator.genFunctionSignature(symTab, (IDENT1!=null?IDENT1.getText():null), t, p, true, PROTO_KW2);
						
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "proto"



	// $ANTLR start "function"
	// ./src/VSLTreeParser.g:71:1: function[SymbolTable symTab] returns [Code3a code3a] : ^( FUNC_KW t= type[symTab] IDENT p= param_list[symTab] ^( BODY st= statement[symTab] ) ) ;
	public final Code3a function(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT3=null;
		CommonTree FUNC_KW4=null;
		Type t =null;
		List<VarSymbol> p =null;
		Code3a st =null;

		try {
			// ./src/VSLTreeParser.g:72:2: ( ^( FUNC_KW t= type[symTab] IDENT p= param_list[symTab] ^( BODY st= statement[symTab] ) ) )
			// ./src/VSLTreeParser.g:73:3: ^( FUNC_KW t= type[symTab] IDENT p= param_list[symTab] ^( BODY st= statement[symTab] ) )
			{
			FUNC_KW4=(CommonTree)match(input,FUNC_KW,FOLLOW_FUNC_KW_in_function291); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_function298);
			t=type(symTab);
			state._fsp--;

			IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function304); 
			pushFollow(FOLLOW_param_list_in_function311);
			p=param_list(symTab);
			state._fsp--;


							code3a = Code3aGenerator.genFunctionSignature(symTab, (IDENT3!=null?IDENT3.getText():null), t, p, false, FUNC_KW4);
						
			match(input,BODY,FOLLOW_BODY_in_function329); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_statement_in_function337);
			st=statement(symTab);
			state._fsp--;


								code3a.append(st);
							
			match(input, Token.UP, null); 


							symTab.leaveScope();
							code3a.append(Code3aGenerator.genEndFunc());
						
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "function"



	// $ANTLR start "type"
	// ./src/VSLTreeParser.g:97:1: type[SymbolTable symTab] returns [Type typeFunc] : ( INT_KW | VOID_KW );
	public final Type type(SymbolTable symTab) throws RecognitionException {
		Type typeFunc = null;


		try {
			// ./src/VSLTreeParser.g:98:2: ( INT_KW | VOID_KW )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==INT_KW) ) {
				alt3=1;
			}
			else if ( (LA3_0==VOID_KW) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// ./src/VSLTreeParser.g:100:3: INT_KW
					{
					match(input,INT_KW,FOLLOW_INT_KW_in_type382); 

								typeFunc = Type.INT;
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:107:3: VOID_KW
					{
					match(input,VOID_KW,FOLLOW_VOID_KW_in_type398); 

								typeFunc = Type.VOID;
							
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return typeFunc;
	}
	// $ANTLR end "type"



	// $ANTLR start "param_list"
	// ./src/VSLTreeParser.g:114:1: param_list[SymbolTable symTab] returns [List<VarSymbol> vars] : ( ^( PARAM (par= param[symTab] )* ) | PARAM );
	public final List<VarSymbol> param_list(SymbolTable symTab) throws RecognitionException {
		List<VarSymbol> vars = null;


		VarSymbol par =null;


				vars = new ArrayList<VarSymbol>();
			
		try {
			// ./src/VSLTreeParser.g:119:2: ( ^( PARAM (par= param[symTab] )* ) | PARAM )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==PARAM) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==DOWN) ) {
					alt5=1;
				}
				else if ( (LA5_1==UP||LA5_1==BODY) ) {
					alt5=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// ./src/VSLTreeParser.g:121:3: ^( PARAM (par= param[symTab] )* )
					{
					match(input,PARAM,FOLLOW_PARAM_in_param_list438); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// ./src/VSLTreeParser.g:122:9: (par= param[symTab] )*
						loop4:
						while (true) {
							int alt4=2;
							int LA4_0 = input.LA(1);
							if ( (LA4_0==IDENT||LA4_0==ARRAY) ) {
								alt4=1;
							}

							switch (alt4) {
							case 1 :
								// ./src/VSLTreeParser.g:123:5: par= param[symTab]
								{
								pushFollow(FOLLOW_param_in_param_list447);
								par=param(symTab);
								state._fsp--;


													vars.add(par);
												
								}
								break;

							default :
								break loop4;
							}
						}

						match(input, Token.UP, null); 
					}

					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:133:3: PARAM
					{
					match(input,PARAM,FOLLOW_PARAM_in_param_list477); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return vars;
	}
	// $ANTLR end "param_list"



	// $ANTLR start "param"
	// ./src/VSLTreeParser.g:137:1: param[SymbolTable symTab] returns [VarSymbol par] : ( IDENT | ^( ARRAY IDENT ) );
	public final VarSymbol param(SymbolTable symTab) throws RecognitionException {
		VarSymbol par = null;


		CommonTree IDENT5=null;
		CommonTree IDENT6=null;

		try {
			// ./src/VSLTreeParser.g:138:2: ( IDENT | ^( ARRAY IDENT ) )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==IDENT) ) {
				alt6=1;
			}
			else if ( (LA6_0==ARRAY) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// ./src/VSLTreeParser.g:140:3: IDENT
					{
					IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param501); 

								par = Code3aGenerator.genParam(symTab, (IDENT5!=null?IDENT5.getText():null));
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:148:3: ^( ARRAY IDENT )
					{
					match(input,ARRAY,FOLLOW_ARRAY_in_param523); 
					match(input, Token.DOWN, null); 
					IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param528); 

									par = Code3aGenerator.genArrayParam(symTab, (IDENT6!=null?IDENT6.getText():null));
								
					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return par;
	}
	// $ANTLR end "param"



	// $ANTLR start "statement"
	// ./src/VSLTreeParser.g:158:1: statement[SymbolTable symTab] returns [Code3a code3a] : ( ^( ASSIGN_KW e1= expression[symTab] ( ( IDENT ) | (a= array_elem[symTab] ) ) ) |b= block[symTab] | ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pr= print_list[symTab] ) | ^( READ_KW r= read_list[symTab] ) | ^( RETURN_KW e= expression[symTab] ) | ^( FCALL_S IDENT (al= argument_list[symTab] )? ) );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT7=null;
		CommonTree ASSIGN_KW8=null;
		CommonTree RETURN_KW9=null;
		CommonTree IDENT10=null;
		CommonTree FCALL_S11=null;
		ExpAttribute e1 =null;
		ExpArrayAttribute a =null;
		Code3a b =null;
		Code3a s1 =null;
		Code3a s2 =null;
		ExpAttribute e =null;
		Code3a st =null;
		Code3a pr =null;
		Code3a r =null;
		TreeRuleReturnScope al =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:163:2: ( ^( ASSIGN_KW e1= expression[symTab] ( ( IDENT ) | (a= array_elem[symTab] ) ) ) |b= block[symTab] | ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pr= print_list[symTab] ) | ^( READ_KW r= read_list[symTab] ) | ^( RETURN_KW e= expression[symTab] ) | ^( FCALL_S IDENT (al= argument_list[symTab] )? ) )
			int alt10=8;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt10=1;
				}
				break;
			case BLOCK:
				{
				alt10=2;
				}
				break;
			case IF_KW:
				{
				alt10=3;
				}
				break;
			case WHILE_KW:
				{
				alt10=4;
				}
				break;
			case PRINT_KW:
				{
				alt10=5;
				}
				break;
			case READ_KW:
				{
				alt10=6;
				}
				break;
			case RETURN_KW:
				{
				alt10=7;
				}
				break;
			case FCALL_S:
				{
				alt10=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// ./src/VSLTreeParser.g:165:3: ^( ASSIGN_KW e1= expression[symTab] ( ( IDENT ) | (a= array_elem[symTab] ) ) )
					{
					ASSIGN_KW8=(CommonTree)match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement573); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement580);
					e1=expression(symTab);
					state._fsp--;

					// ./src/VSLTreeParser.g:168:4: ( ( IDENT ) | (a= array_elem[symTab] ) )
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==IDENT) ) {
						alt7=1;
					}
					else if ( (LA7_0==ARELEM) ) {
						alt7=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 7, 0, input);
						throw nvae;
					}

					switch (alt7) {
						case 1 :
							// ./src/VSLTreeParser.g:170:5: ( IDENT )
							{
							// ./src/VSLTreeParser.g:170:5: ( IDENT )
							// ./src/VSLTreeParser.g:171:6: IDENT
							{
							IDENT7=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement604); 

													code3a = Code3aGenerator.genAffExpr(symTab, e1, (IDENT7!=null?IDENT7.getText():null), ASSIGN_KW8);
												
							}

							}
							break;
						case 2 :
							// ./src/VSLTreeParser.g:180:5: (a= array_elem[symTab] )
							{
							// ./src/VSLTreeParser.g:180:5: (a= array_elem[symTab] )
							// ./src/VSLTreeParser.g:181:6: a= array_elem[symTab]
							{
							pushFollow(FOLLOW_array_elem_in_statement645);
							a=array_elem(symTab);
							state._fsp--;

							}


													code3a = e1.code;
													code3a.append(Code3aGenerator.genVarTab(a, e1.place));
												
							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:193:3: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement685);
					b=block(symTab);
					state._fsp--;


								code3a = b;
							
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:201:3: ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement708); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement715);
					e1=expression(symTab);
					state._fsp--;


									LabelSymbol l_else = SymbDistrib.newLabel();
									LabelSymbol l_end = SymbDistrib.newLabel();
									code3a = Code3aGenerator.genIfStatement(e1, l_else);
								
					pushFollow(FOLLOW_statement_in_statement731);
					s1=statement(symTab);
					state._fsp--;


									code3a.append(s1);
									code3a.append(Code3aGenerator.genGoTo(l_end));
									code3a.append(Code3aGenerator.genLabel(l_else));
								
					// ./src/VSLTreeParser.g:216:4: (s2= statement[symTab] )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==ASSIGN_KW||LA8_0==IF_KW||LA8_0==PRINT_KW||(LA8_0 >= READ_KW && LA8_0 <= RETURN_KW)||LA8_0==WHILE_KW||LA8_0==BLOCK||LA8_0==FCALL_S) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// ./src/VSLTreeParser.g:217:5: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement752);
							s2=statement(symTab);
							state._fsp--;


												code3a.append(s2);
											
							}
							break;

					}


									code3a.append(Code3aGenerator.genLabel(l_end));
								
					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:230:3: ^( WHILE_KW e= expression[symTab] st= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement792); 

									LabelSymbol l_while = SymbDistrib.newLabel();
									LabelSymbol l_end = SymbDistrib.newLabel();
								
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement805);
					e=expression(symTab);
					state._fsp--;


									code3a = Code3aGenerator.genLabel(l_while);
									code3a.append(Code3aGenerator.genWhileStatement(e, l_end));
								
					pushFollow(FOLLOW_statement_in_statement819);
					st=statement(symTab);
					state._fsp--;


									code3a.append(st);
									code3a.append(Code3aGenerator.genGoTo(l_while));
									code3a.append(Code3aGenerator.genLabel(l_end));
								
					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:254:3: ^( PRINT_KW pr= print_list[symTab] )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement847); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_print_list_in_statement854);
					pr=print_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


								code3a = pr;
							
					}
					break;
				case 6 :
					// ./src/VSLTreeParser.g:265:3: ^( READ_KW r= read_list[symTab] )
					{
					match(input,READ_KW,FOLLOW_READ_KW_in_statement881); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_read_list_in_statement888);
					r=read_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


								code3a = r;
							
					}
					break;
				case 7 :
					// ./src/VSLTreeParser.g:276:3: ^( RETURN_KW e= expression[symTab] )
					{
					RETURN_KW9=(CommonTree)match(input,RETURN_KW,FOLLOW_RETURN_KW_in_statement915); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement922);
					e=expression(symTab);
					state._fsp--;


									code3a = Code3aGenerator.genReturn(e, RETURN_KW9);
								
					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// ./src/VSLTreeParser.g:287:3: ^( FCALL_S IDENT (al= argument_list[symTab] )? )
					{
					FCALL_S11=(CommonTree)match(input,FCALL_S,FOLLOW_FCALL_S_in_statement950); 
					match(input, Token.DOWN, null); 
					IDENT10=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement955); 
					// ./src/VSLTreeParser.g:290:4: (al= argument_list[symTab] )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==DIV||LA9_0==IDENT||LA9_0==INTEGER||(LA9_0 >= MINUS && LA9_0 <= MUL)||LA9_0==PLUS||LA9_0==ARELEM||LA9_0==FCALL) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// ./src/VSLTreeParser.g:291:5: al= argument_list[symTab]
							{
							pushFollow(FOLLOW_argument_list_in_statement968);
							al=argument_list(symTab);
							state._fsp--;

							}
							break;

					}


									code3a = Code3aGenerator.genFunctionCallInStatement(symTab, (IDENT10!=null?IDENT10.getText():null), (argument_list_return) al, FCALL_S11);
								
					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "statement"



	// $ANTLR start "block"
	// ./src/VSLTreeParser.g:300:1: block[SymbolTable symTab] returns [Code3a code3a] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a d =null;
		Code3a il =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:305:2: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==BLOCK) ) {
				int LA11_1 = input.LA(2);
				if ( (LA11_1==DOWN) ) {
					int LA11_2 = input.LA(3);
					if ( (LA11_2==DECL) ) {
						alt11=1;
					}
					else if ( (LA11_2==INST) ) {
						alt11=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 11, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 11, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// ./src/VSLTreeParser.g:307:3: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block1020); 

									symTab.enterScope();
								
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block1033);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block1038);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


								code3a = d;
								code3a.append(il);
								symTab.leaveScope();
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:323:3: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block1065); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block1072);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


								code3a = il;
							
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "block"



	// $ANTLR start "inst_list"
	// ./src/VSLTreeParser.g:333:1: inst_list[SymbolTable symTab] returns [Code3a code3a] : ^( INST (il= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a il =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:338:2: ( ^( INST (il= statement[symTab] )+ ) )
			// ./src/VSLTreeParser.g:339:3: ^( INST (il= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list1113); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:340:8: (il= statement[symTab] )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==ASSIGN_KW||LA12_0==IF_KW||LA12_0==PRINT_KW||(LA12_0 >= READ_KW && LA12_0 <= RETURN_KW)||LA12_0==WHILE_KW||LA12_0==BLOCK||LA12_0==FCALL_S) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// ./src/VSLTreeParser.g:341:5: il= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list1122);
					il=statement(symTab);
					state._fsp--;


										code3a.append(il);
									
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "inst_list"



	// $ANTLR start "array_elem"
	// ./src/VSLTreeParser.g:350:1: array_elem[SymbolTable symTab] returns [ExpArrayAttribute exp] : ^( ARELEM IDENT e= expression[symTab] ) ;
	public final ExpArrayAttribute array_elem(SymbolTable symTab) throws RecognitionException {
		ExpArrayAttribute exp = null;


		CommonTree IDENT12=null;
		CommonTree ARELEM13=null;
		ExpAttribute e =null;

		try {
			// ./src/VSLTreeParser.g:351:2: ( ^( ARELEM IDENT e= expression[symTab] ) )
			// ./src/VSLTreeParser.g:352:3: ^( ARELEM IDENT e= expression[symTab] )
			{
			ARELEM13=(CommonTree)match(input,ARELEM,FOLLOW_ARELEM_in_array_elem1164); 
			match(input, Token.DOWN, null); 
			IDENT12=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_array_elem1170); 
			pushFollow(FOLLOW_expression_in_array_elem1177);
			e=expression(symTab);
			state._fsp--;


							exp = Code3aGenerator.genArrayElement(symTab, (IDENT12!=null?IDENT12.getText():null), e, ARELEM13);
						
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return exp;
	}
	// $ANTLR end "array_elem"



	// $ANTLR start "expression"
	// ./src/VSLTreeParser.g:363:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// ./src/VSLTreeParser.g:364:2: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt13=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt13=1;
				}
				break;
			case MINUS:
				{
				alt13=2;
				}
				break;
			case MUL:
				{
				alt13=3;
				}
				break;
			case DIV:
				{
				alt13=4;
				}
				break;
			case IDENT:
			case INTEGER:
			case ARELEM:
			case FCALL:
				{
				alt13=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// ./src/VSLTreeParser.g:366:3: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression1217); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1224);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1232);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


								Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
								VarSymbol temp = SymbDistrib.newTemp();
								Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
								expAtt = new ExpAttribute(ty, cod, temp);
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:381:3: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression1259); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1266);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1274);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


								Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
								VarSymbol temp = SymbDistrib.newTemp();
								Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
								expAtt = new ExpAttribute(ty, cod, temp);
							
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:396:3: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression1301); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1308);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1316);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


								Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
								VarSymbol temp = SymbDistrib.newTemp();
								Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
								expAtt = new ExpAttribute(ty, cod, temp);
							
					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:411:3: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression1343); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1350);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1358);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


								Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
								VarSymbol temp = SymbDistrib.newTemp();
								Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
								expAtt = new ExpAttribute(ty, cod, temp);
							
					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:426:3: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression1382);
					pe=primary_exp(symTab);
					state._fsp--;


								expAtt = pe; 
							
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "expression"



	// $ANTLR start "primary_exp"
	// ./src/VSLTreeParser.g:434:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT | ^( FCALL IDENT (al= argument_list[symTab] )? ) |a= array_elem[symTab] );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER14=null;
		CommonTree IDENT15=null;
		CommonTree IDENT16=null;
		CommonTree FCALL17=null;
		TreeRuleReturnScope al =null;
		ExpArrayAttribute a =null;

		try {
			// ./src/VSLTreeParser.g:435:2: ( INTEGER | IDENT | ^( FCALL IDENT (al= argument_list[symTab] )? ) |a= array_elem[symTab] )
			int alt15=4;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt15=1;
				}
				break;
			case IDENT:
				{
				alt15=2;
				}
				break;
			case FCALL:
				{
				alt15=3;
				}
				break;
			case ARELEM:
				{
				alt15=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// ./src/VSLTreeParser.g:437:3: INTEGER
					{
					INTEGER14=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp1413); 

								ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER14!=null?INTEGER14.getText():null)));
								expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:446:3: IDENT
					{
					IDENT15=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp1430); 

								Operand3a id = symTab.lookup((IDENT15!=null?IDENT15.getText():null));
								if(id == null) {
									Errors.unknownIdentifier(IDENT15, (IDENT15!=null?IDENT15.getText():null), null);
									System.err.println("Compilation terminated");
									System.exit(-1);
								}
								expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT15!=null?IDENT15.getText():null)));
							
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:460:3: ^( FCALL IDENT (al= argument_list[symTab] )? )
					{
					FCALL17=(CommonTree)match(input,FCALL,FOLLOW_FCALL_in_primary_exp1452); 
					match(input, Token.DOWN, null); 
					IDENT16=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp1457); 
					// ./src/VSLTreeParser.g:463:4: (al= argument_list[symTab] )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==DIV||LA14_0==IDENT||LA14_0==INTEGER||(LA14_0 >= MINUS && LA14_0 <= MUL)||LA14_0==PLUS||LA14_0==ARELEM||LA14_0==FCALL) ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// ./src/VSLTreeParser.g:464:5: al= argument_list[symTab]
							{
							pushFollow(FOLLOW_argument_list_in_primary_exp1470);
							al=argument_list(symTab);
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


								expAtt = Code3aGenerator.genFunctionCallInPrimaryExp(symTab, (IDENT16!=null?IDENT16.getText():null), (argument_list_return) al, FCALL17);
							
					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:474:3: a= array_elem[symTab]
					{
					pushFollow(FOLLOW_array_elem_in_primary_exp1500);
					a=array_elem(symTab);
					state._fsp--;


								expAtt = a.exp;
							
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "primary_exp"


	public static class argument_list_return extends TreeRuleReturnScope {
		public Code3a code;
		public List<Type> args;
	};


	// $ANTLR start "argument_list"
	// ./src/VSLTreeParser.g:481:1: argument_list[SymbolTable symTab] returns [Code3a code, List<Type> args] : (e= expression[symTab] )+ ;
	public final VSLTreeParser.argument_list_return argument_list(SymbolTable symTab) throws RecognitionException {
		VSLTreeParser.argument_list_return retval = new VSLTreeParser.argument_list_return();
		retval.start = input.LT(1);

		ExpAttribute e =null;


				retval.code = new Code3a();
				retval.args = new ArrayList<Type>();
			
		try {
			// ./src/VSLTreeParser.g:487:2: ( (e= expression[symTab] )+ )
			// ./src/VSLTreeParser.g:488:3: (e= expression[symTab] )+
			{
			// ./src/VSLTreeParser.g:488:3: (e= expression[symTab] )+
			int cnt16=0;
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==DIV||LA16_0==IDENT||LA16_0==INTEGER||(LA16_0 >= MINUS && LA16_0 <= MUL)||LA16_0==PLUS||LA16_0==ARELEM||LA16_0==FCALL) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// ./src/VSLTreeParser.g:489:4: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_argument_list1539);
					e=expression(symTab);
					state._fsp--;


									retval.args.add(e.type);
									retval.code.append(e.code);
									retval.code.append(Code3aGenerator.genArg(e.place));
								
					}
					break;

				default :
					if ( cnt16 >= 1 ) break loop16;
					EarlyExitException eee = new EarlyExitException(16, input);
					throw eee;
				}
				cnt16++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "argument_list"



	// $ANTLR start "print_list"
	// ./src/VSLTreeParser.g:499:1: print_list[SymbolTable symTab] returns [Code3a code3a] : (pr_list= print_item[symTab] )+ ;
	public final Code3a print_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a pr_list =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:504:2: ( (pr_list= print_item[symTab] )+ )
			// ./src/VSLTreeParser.g:505:3: (pr_list= print_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:505:3: (pr_list= print_item[symTab] )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==DIV||LA17_0==IDENT||LA17_0==INTEGER||(LA17_0 >= MINUS && LA17_0 <= MUL)||LA17_0==PLUS||LA17_0==TEXT||LA17_0==ARELEM||LA17_0==FCALL) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// ./src/VSLTreeParser.g:506:4: pr_list= print_item[symTab]
					{
					pushFollow(FOLLOW_print_item_in_print_list1584);
					pr_list=print_item(symTab);
					state._fsp--;


									code3a.append(pr_list);
								
					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
					EarlyExitException eee = new EarlyExitException(17, input);
					throw eee;
				}
				cnt17++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "print_list"



	// $ANTLR start "print_item"
	// ./src/VSLTreeParser.g:514:1: print_item[SymbolTable symTab] returns [Code3a code3a] : ( TEXT |e= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree TEXT18=null;
		ExpAttribute e =null;

		try {
			// ./src/VSLTreeParser.g:515:2: ( TEXT |e= expression[symTab] )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==TEXT) ) {
				alt18=1;
			}
			else if ( (LA18_0==DIV||LA18_0==IDENT||LA18_0==INTEGER||(LA18_0 >= MINUS && LA18_0 <= MUL)||LA18_0==PLUS||LA18_0==ARELEM||LA18_0==FCALL) ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// ./src/VSLTreeParser.g:517:3: TEXT
					{
					TEXT18=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item1619); 

								code3a = Code3aGenerator.genPrintString((TEXT18!=null?TEXT18.getText():null));	
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:525:3: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item1638);
					e=expression(symTab);
					state._fsp--;


								code3a = Code3aGenerator.genPrintExpr(e);
							
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "print_item"



	// $ANTLR start "read_list"
	// ./src/VSLTreeParser.g:532:1: read_list[SymbolTable symTab] returns [Code3a code3a] : (rl= read_item[symTab] )+ ;
	public final Code3a read_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a rl =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:537:2: ( (rl= read_item[symTab] )+ )
			// ./src/VSLTreeParser.g:538:3: (rl= read_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:538:3: (rl= read_item[symTab] )+
			int cnt19=0;
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==IDENT||LA19_0==ARELEM) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// ./src/VSLTreeParser.g:539:4: rl= read_item[symTab]
					{
					pushFollow(FOLLOW_read_item_in_read_list1677);
					rl=read_item(symTab);
					state._fsp--;


									code3a.append(rl);
								
					}
					break;

				default :
					if ( cnt19 >= 1 ) break loop19;
					EarlyExitException eee = new EarlyExitException(19, input);
					throw eee;
				}
				cnt19++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "read_list"



	// $ANTLR start "read_item"
	// ./src/VSLTreeParser.g:547:1: read_item[SymbolTable symTab] returns [Code3a code3a] : ( IDENT |a= array_elem[symTab] );
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT19=null;
		ExpArrayAttribute a =null;

		try {
			// ./src/VSLTreeParser.g:548:2: ( IDENT |a= array_elem[symTab] )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==IDENT) ) {
				alt20=1;
			}
			else if ( (LA20_0==ARELEM) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// ./src/VSLTreeParser.g:550:3: IDENT
					{
					IDENT19=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item1712); 

								code3a = Code3aGenerator.genReadIdent(symTab, (IDENT19!=null?IDENT19.getText():null), IDENT19);
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:558:3: a= array_elem[symTab]
					{
					pushFollow(FOLLOW_array_elem_in_read_item1731);
					a=array_elem(symTab);
					state._fsp--;


								code3a = Code3aGenerator.genReadArray(symTab, a);
							
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "read_item"



	// $ANTLR start "declaration"
	// ./src/VSLTreeParser.g:567:1: declaration[SymbolTable symTab] returns [Code3a code3a] : ^( DECL (value= decl_item[symTab] )+ ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a value =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:572:2: ( ^( DECL (value= decl_item[symTab] )+ ) )
			// ./src/VSLTreeParser.g:573:3: ^( DECL (value= decl_item[symTab] )+ )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration1770); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:575:4: (value= decl_item[symTab] )+
			int cnt21=0;
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==IDENT||LA21_0==ARDECL) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// ./src/VSLTreeParser.g:576:5: value= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_declaration1786);
					value=decl_item(symTab);
					state._fsp--;


										code3a.append(value);
									
					}
					break;

				default :
					if ( cnt21 >= 1 ) break loop21;
					EarlyExitException eee = new EarlyExitException(21, input);
					throw eee;
				}
				cnt21++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "declaration"



	// $ANTLR start "decl_item"
	// ./src/VSLTreeParser.g:585:1: decl_item[SymbolTable symTab] returns [Code3a code3a] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT20=null;
		CommonTree IDENT21=null;
		CommonTree INTEGER22=null;
		CommonTree ARDECL23=null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:590:2: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==IDENT) ) {
				alt22=1;
			}
			else if ( (LA22_0==ARDECL) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// ./src/VSLTreeParser.g:592:3: IDENT
					{
					IDENT20=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1834); 

								code3a.append(Code3aGenerator.genDeclVar(symTab, (IDENT20!=null?IDENT20.getText():null), IDENT20));
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:599:3: ^( ARDECL IDENT INTEGER )
					{
					ARDECL23=(CommonTree)match(input,ARDECL,FOLLOW_ARDECL_in_decl_item1856); 
					match(input, Token.DOWN, null); 
					IDENT21=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1861); 
					INTEGER22=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item1866); 

									code3a.append(Code3aGenerator.genDeclArray(symTab, (IDENT21!=null?IDENT21.getText():null), Integer.parseInt((INTEGER22!=null?INTEGER22.getText():null)), ARDECL23));
								
					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "decl_item"

	// Delegated rules



	public static final BitSet FOLLOW_program_in_s69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROG_in_program106 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_unit_in_program115 = new BitSet(new long[]{0x0000000008002008L});
	public static final BitSet FOLLOW_function_in_unit167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_proto_in_unit199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROTO_KW_in_proto236 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_proto243 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_proto249 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_param_list_in_proto256 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_KW_in_function291 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_function298 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_function304 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_param_list_in_function311 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_BODY_in_function329 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_function337 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INT_KW_in_type382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KW_in_type398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARAM_in_param_list438 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_param_list447 = new BitSet(new long[]{0x0000010000004008L});
	public static final BitSet FOLLOW_PARAM_in_param_list477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_param501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_param523 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_param528 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement573 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement580 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement604 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_array_elem_in_statement645 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement685 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_KW_in_statement708 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement715 = new BitSet(new long[]{0x00002210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement731 = new BitSet(new long[]{0x00002210C4008028L});
	public static final BitSet FOLLOW_statement_in_statement752 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement792 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement805 = new BitSet(new long[]{0x00002210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement819 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement847 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_list_in_statement854 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_KW_in_statement881 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_list_in_statement888 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_KW_in_statement915 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement922 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FCALL_S_in_statement950 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_statement955 = new BitSet(new long[]{0x0000108002C14208L});
	public static final BitSet FOLLOW_argument_list_in_statement968 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block1020 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block1033 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block1038 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block1065 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block1072 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list1113 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list1122 = new BitSet(new long[]{0x00002210C4008028L});
	public static final BitSet FOLLOW_ARELEM_in_array_elem1164 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_array_elem1170 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_array_elem1177 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_expression1217 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1224 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1232 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression1259 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1266 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1274 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression1301 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1308 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1316 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression1343 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1350 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1358 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression1382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp1413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp1430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FCALL_in_primary_exp1452 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp1457 = new BitSet(new long[]{0x0000108002C14208L});
	public static final BitSet FOLLOW_argument_list_in_primary_exp1470 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_array_elem_in_primary_exp1500 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_argument_list1539 = new BitSet(new long[]{0x0000108002C14202L});
	public static final BitSet FOLLOW_print_item_in_print_list1584 = new BitSet(new long[]{0x0000108202C14202L});
	public static final BitSet FOLLOW_TEXT_in_print_item1619 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item1638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_item_in_read_list1677 = new BitSet(new long[]{0x0000008000004002L});
	public static final BitSet FOLLOW_IDENT_in_read_item1712 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_elem_in_read_item1731 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECL_in_declaration1770 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_item_in_declaration1786 = new BitSet(new long[]{0x0000004000004008L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1834 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item1856 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1861 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item1866 = new BitSet(new long[]{0x0000000000000008L});
}
