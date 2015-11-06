// $ANTLR 3.5 ./src/VSLTreeParser.g 2015-11-06 14:13:41

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
	// ./src/VSLTreeParser.g:11:1: s[SymbolTable symTab] returns [Code3a code] : (e= expression[symTab] |st= statement[symTab] );
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		ExpAttribute e =null;
		Code3a st =null;

		try {
			// ./src/VSLTreeParser.g:12:2: (e= expression[symTab] |st= statement[symTab] )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==DIV||LA1_0==IDENT||LA1_0==INTEGER||(LA1_0 >= MINUS && LA1_0 <= MUL)||LA1_0==PLUS||LA1_0==NEGAT) ) {
				alt1=1;
			}
			else if ( (LA1_0==ASSIGN_KW||LA1_0==IF_KW||LA1_0==PRINT_KW||LA1_0==READ_KW||LA1_0==WHILE_KW||LA1_0==BLOCK) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// ./src/VSLTreeParser.g:13:3: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_s69);
					e=expression(symTab);
					state._fsp--;


						 		code = e.code;
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:20:3: st= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_s86);
					st=statement(symTab);
					state._fsp--;


						  		code = st;
							
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
		return code;
	}
	// $ANTLR end "s"



	// $ANTLR start "function"
	// ./src/VSLTreeParser.g:27:1: function[SymbolTable symTab] returns [Code3a code3a] : ^( FUNC_KW t= type[symTab] IDENT p= param_list[symTab] ^( BODY st= statement[symTab] ) ) ;
	public final Code3a function(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT1=null;
		Type t =null;
		Code3a p =null;
		Code3a st =null;

		try {
			// ./src/VSLTreeParser.g:28:2: ( ^( FUNC_KW t= type[symTab] IDENT p= param_list[symTab] ^( BODY st= statement[symTab] ) ) )
			// ./src/VSLTreeParser.g:29:3: ^( FUNC_KW t= type[symTab] IDENT p= param_list[symTab] ^( BODY st= statement[symTab] ) )
			{
			match(input,FUNC_KW,FOLLOW_FUNC_KW_in_function116); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_function123);
			t=type(symTab);
			state._fsp--;

			IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function129); 

							LabelSymbol l_func = new LabelSymbol((IDENT1!=null?IDENT1.getText():null));
							code3a = Code3aGenerator.genBeginFunc();
							FunctionSymbol function = new FunctionSymbol(l_func, new FunctionType(t, false));

						
			pushFollow(FOLLOW_param_list_in_function142);
			p=param_list(symTab);
			state._fsp--;


							code3a.append(p);
						
			match(input,BODY,FOLLOW_BODY_in_function160); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_statement_in_function168);
			st=statement(symTab);
			state._fsp--;


								code3a.append(st);
							
			match(input, Token.UP, null); 


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
	// ./src/VSLTreeParser.g:59:1: type[SymbolTable symTab] returns [Type typeFunc] : ( INT_KW | VOID_KW );
	public final Type type(SymbolTable symTab) throws RecognitionException {
		Type typeFunc = null;


		try {
			// ./src/VSLTreeParser.g:60:2: ( INT_KW | VOID_KW )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==INT_KW) ) {
				alt2=1;
			}
			else if ( (LA2_0==VOID_KW) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// ./src/VSLTreeParser.g:61:3: INT_KW
					{
					match(input,INT_KW,FOLLOW_INT_KW_in_type209); 

								typeFunc = Type.INT;
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:66:3: VOID_KW
					{
					match(input,VOID_KW,FOLLOW_VOID_KW_in_type220); 

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
	// ./src/VSLTreeParser.g:73:1: param_list[SymbolTable symTab] returns [Code3a code3a] : ( ^( PARAM (par= param[symTab] )* ) | PARAM );
	public final Code3a param_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a par =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:78:2: ( ^( PARAM (par= param[symTab] )* ) | PARAM )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==PARAM) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==DOWN) ) {
					alt4=1;
				}
				else if ( (LA4_1==BODY) ) {
					alt4=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// ./src/VSLTreeParser.g:79:3: ^( PARAM (par= param[symTab] )* )
					{
					match(input,PARAM,FOLLOW_PARAM_in_param_list256); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// ./src/VSLTreeParser.g:80:9: (par= param[symTab] )*
						loop3:
						while (true) {
							int alt3=2;
							int LA3_0 = input.LA(1);
							if ( (LA3_0==IDENT) ) {
								alt3=1;
							}

							switch (alt3) {
							case 1 :
								// ./src/VSLTreeParser.g:81:5: par= param[symTab]
								{
								pushFollow(FOLLOW_param_in_param_list265);
								par=param(symTab);
								state._fsp--;


													code3a.append(par);
												
								}
								break;

							default :
								break loop3;
							}
						}

						match(input, Token.UP, null); 
					}

					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:89:3: PARAM
					{
					match(input,PARAM,FOLLOW_PARAM_in_param_list290); 
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
	// $ANTLR end "param_list"



	// $ANTLR start "param"
	// ./src/VSLTreeParser.g:92:1: param[SymbolTable symTab] returns [Code3a code3a] : IDENT ;
	public final Code3a param(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT2=null;

		try {
			// ./src/VSLTreeParser.g:93:2: ( IDENT )
			// ./src/VSLTreeParser.g:94:3: IDENT
			{
			IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param308); 

						code3a = Code3aGenerator.genParamFunc(symTab, (IDENT2!=null?IDENT2.getText():null));
					
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
	// $ANTLR end "param"



	// $ANTLR start "statement"
	// ./src/VSLTreeParser.g:102:1: statement[SymbolTable symTab] returns [Code3a code3a] : ( ^( ASSIGN_KW e1= expression[symTab] IDENT () ) |b= block[symTab] | ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pr= print_list[symTab] ) | ^( READ_KW r= read_list[symTab] ) );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT3=null;
		ExpAttribute e1 =null;
		Code3a b =null;
		Code3a s1 =null;
		Code3a s2 =null;
		ExpAttribute e =null;
		Code3a st =null;
		Code3a pr =null;
		Code3a r =null;


		    	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:107:4: ( ^( ASSIGN_KW e1= expression[symTab] IDENT () ) |b= block[symTab] | ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pr= print_list[symTab] ) | ^( READ_KW r= read_list[symTab] ) )
			int alt6=6;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt6=1;
				}
				break;
			case BLOCK:
				{
				alt6=2;
				}
				break;
			case IF_KW:
				{
				alt6=3;
				}
				break;
			case WHILE_KW:
				{
				alt6=4;
				}
				break;
			case PRINT_KW:
				{
				alt6=5;
				}
				break;
			case READ_KW:
				{
				alt6=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// ./src/VSLTreeParser.g:108:5: ^( ASSIGN_KW e1= expression[symTab] IDENT () )
					{
					match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement355); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement359);
					e1=expression(symTab);
					state._fsp--;

					IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement362); 
					// ./src/VSLTreeParser.g:109:9: ()
					// ./src/VSLTreeParser.g:110:11: 
					{

					          			code3a = Code3aGenerator.genAffExpr(symTab, e1, (IDENT3!=null?IDENT3.getText():null));
					        		
					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:118:5: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement417);
					b=block(symTab);
					state._fsp--;


					        	code3a = b;
					    	
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:125:6: ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement448); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement458);
					e1=expression(symTab);
					state._fsp--;


					    			LabelSymbol l_else = SymbDistrib.newLabel();
					    			LabelSymbol l_end = SymbDistrib.newLabel();
					    			code3a = Code3aGenerator.genIfStatement(e1, l_else);
					    		
					pushFollow(FOLLOW_statement_in_statement480);
					s1=statement(symTab);
					state._fsp--;


					    			code3a.append(s1);
					    			code3a.append(Code3aGenerator.genGoTo(l_end));
					    			code3a.append(Code3aGenerator.genLabel(l_else));
					    		
					// ./src/VSLTreeParser.g:140:7: (s2= statement[symTab] )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==ASSIGN_KW||LA5_0==IF_KW||LA5_0==PRINT_KW||LA5_0==READ_KW||LA5_0==WHILE_KW||LA5_0==BLOCK) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// ./src/VSLTreeParser.g:141:8: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement510);
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
					// ./src/VSLTreeParser.g:153:7: ^( WHILE_KW e= expression[symTab] st= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement570); 

					          LabelSymbol l_while = SymbDistrib.newLabel();
					          LabelSymbol l_end = SymbDistrib.newLabel();
					        
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement593);
					e=expression(symTab);
					state._fsp--;


					          code3a = Code3aGenerator.genWhileStatement(e, l_end);
					        
					pushFollow(FOLLOW_statement_in_statement617);
					st=statement(symTab);
					state._fsp--;


					          code3a.append(st);
					          code3a.append(Code3aGenerator.genGoTo(l_while));
					        
					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:174:6: ^( PRINT_KW pr= print_list[symTab] )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement660); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_print_list_in_statement670);
					pr=print_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					    		code3a = pr;
					    	
					}
					break;
				case 6 :
					// ./src/VSLTreeParser.g:184:6: ^( READ_KW r= read_list[symTab] )
					{
					match(input,READ_KW,FOLLOW_READ_KW_in_statement709); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_read_list_in_statement719);
					r=read_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        	code3a = r;
					    	
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
	// ./src/VSLTreeParser.g:194:1: block[SymbolTable symTab] returns [Code3a code3a] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a d =null;
		Code3a il =null;


		      code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:199:2: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==BLOCK) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==DOWN) ) {
					int LA7_2 = input.LA(3);
					if ( (LA7_2==DECL) ) {
						alt7=1;
					}
					else if ( (LA7_2==INST) ) {
						alt7=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 7, 2, input);
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
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// ./src/VSLTreeParser.g:200:3: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block767); 

					      		symTab.enterScope();
					    	
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block785);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block790);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      		code3a = d;
					      		code3a.append(il);
					      		symTab.leaveScope();
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:215:4: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block817); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block821);
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
	// ./src/VSLTreeParser.g:222:1: inst_list[SymbolTable symTab] returns [Code3a code3a] : ^( INST (il= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a il =null;


		      	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:227:4: ( ^( INST (il= statement[symTab] )+ ) )
			// ./src/VSLTreeParser.g:228:5: ^( INST (il= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list873); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:229:10: (il= statement[symTab] )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==ASSIGN_KW||LA8_0==IF_KW||LA8_0==PRINT_KW||LA8_0==READ_KW||LA8_0==WHILE_KW||LA8_0==BLOCK) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// ./src/VSLTreeParser.g:230:10: il= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list887);
					il=statement(symTab);
					state._fsp--;


					        			code3a.append(il);
					      			
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
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



	// $ANTLR start "expression"
	// ./src/VSLTreeParser.g:239:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( NEGAT e= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute e =null;
		ExpAttribute pe =null;

		try {
			// ./src/VSLTreeParser.g:240:4: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( NEGAT e= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt9=6;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt9=1;
				}
				break;
			case MINUS:
				{
				alt9=2;
				}
				break;
			case MUL:
				{
				alt9=3;
				}
				break;
			case DIV:
				{
				alt9=4;
				}
				break;
			case NEGAT:
				{
				alt9=5;
				}
				break;
			case IDENT:
			case INTEGER:
				{
				alt9=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// ./src/VSLTreeParser.g:242:6: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression948); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression952);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression957);
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
					// ./src/VSLTreeParser.g:253:6: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression988); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression992);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression997);
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
					// ./src/VSLTreeParser.g:264:6: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression1027); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1031);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1036);
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
					// ./src/VSLTreeParser.g:275:6: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression1066); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1070);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1075);
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
					// ./src/VSLTreeParser.g:286:6: ^( NEGAT e= expression[symTab] )
					{
					match(input,NEGAT,FOLLOW_NEGAT_in_expression1105); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1109);
					e=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


								Type ty = TypeCheck.checkUnOp(e.type);
								VarSymbol temp = SymbDistrib.newTemp();
								Code3a cod = Code3aGenerator.genUnOp(Inst3a.TAC.NEG, temp, e);
								expAtt = new ExpAttribute(ty, cod, temp);
						    
					}
					break;
				case 6 :
					// ./src/VSLTreeParser.g:296:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression1133);
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
	// ./src/VSLTreeParser.g:304:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER4=null;
		CommonTree IDENT5=null;

		try {
			// ./src/VSLTreeParser.g:305:4: ( INTEGER | IDENT )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==INTEGER) ) {
				alt10=1;
			}
			else if ( (LA10_0==IDENT) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// ./src/VSLTreeParser.g:306:5: INTEGER
					{
					INTEGER4=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp1167); 

					      		ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER4!=null?INTEGER4.getText():null)));
					      		expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:314:5: IDENT
					{
					IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp1187); 

					      		Operand3a id = symTab.lookup((IDENT5!=null?IDENT5.getText():null));
					      		expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT5!=null?IDENT5.getText():null)));
					    	
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



	// $ANTLR start "print_list"
	// ./src/VSLTreeParser.g:322:1: print_list[SymbolTable symTab] returns [Code3a code3a] : (pr_list= print_item[symTab] )+ ;
	public final Code3a print_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a pr_list =null;


		    	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:327:2: ( (pr_list= print_item[symTab] )+ )
			// ./src/VSLTreeParser.g:328:3: (pr_list= print_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:328:3: (pr_list= print_item[symTab] )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==DIV||LA11_0==IDENT||LA11_0==INTEGER||(LA11_0 >= MINUS && LA11_0 <= MUL)||LA11_0==PLUS||LA11_0==TEXT||LA11_0==NEGAT) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// ./src/VSLTreeParser.g:329:4: pr_list= print_item[symTab]
					{
					pushFollow(FOLLOW_print_item_in_print_list1231);
					pr_list=print_item(symTab);
					state._fsp--;


									code3a.append(pr_list);
								
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
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
	// ./src/VSLTreeParser.g:337:1: print_item[SymbolTable symTab] returns [Code3a code3a] : ( TEXT |e= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree TEXT6=null;
		ExpAttribute e =null;

		try {
			// ./src/VSLTreeParser.g:338:2: ( TEXT |e= expression[symTab] )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==TEXT) ) {
				alt12=1;
			}
			else if ( (LA12_0==DIV||LA12_0==IDENT||LA12_0==INTEGER||(LA12_0 >= MINUS && LA12_0 <= MUL)||LA12_0==PLUS||LA12_0==NEGAT) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// ./src/VSLTreeParser.g:339:3: TEXT
					{
					TEXT6=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item1262); 

								code3a = Code3aGenerator.genPrintString((TEXT6!=null?TEXT6.getText():null));	
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:346:3: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item1277);
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
	// ./src/VSLTreeParser.g:353:1: read_list[SymbolTable symTab] returns [Code3a code3a] : (rl= read_item[symTab] )+ ;
	public final Code3a read_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a rl =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:358:2: ( (rl= read_item[symTab] )+ )
			// ./src/VSLTreeParser.g:359:3: (rl= read_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:359:3: (rl= read_item[symTab] )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==IDENT) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// ./src/VSLTreeParser.g:360:4: rl= read_item[symTab]
					{
					pushFollow(FOLLOW_read_item_in_read_list1316);
					rl=read_item(symTab);
					state._fsp--;


									code3a.append(rl);
								
					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
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
	// ./src/VSLTreeParser.g:368:1: read_item[SymbolTable symTab] returns [Code3a code3a] : IDENT ;
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT7=null;

		try {
			// ./src/VSLTreeParser.g:369:2: ( IDENT )
			// ./src/VSLTreeParser.g:370:3: IDENT
			{
			IDENT7=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item1347); 

						code3a = Code3aGenerator.genReadIdent(symTab, (IDENT7!=null?IDENT7.getText():null));
					
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
	// ./src/VSLTreeParser.g:379:1: declaration[SymbolTable symTab] returns [Code3a code3a] : ^( DECL (value= decl_item[symTab] )+ ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a value =null;


		    	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:384:4: ( ^( DECL (value= decl_item[symTab] )+ ) )
			// ./src/VSLTreeParser.g:384:7: ^( DECL (value= decl_item[symTab] )+ )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration1387); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:385:4: (value= decl_item[symTab] )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==IDENT) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// ./src/VSLTreeParser.g:385:5: value= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_declaration1398);
					value=decl_item(symTab);
					state._fsp--;


					      				code3a.append(value);
					    			
					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
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
	// ./src/VSLTreeParser.g:394:1: decl_item[SymbolTable symTab] returns [Code3a code3a] : IDENT ;
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT8=null;


		     	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:399:4: ( IDENT )
			// ./src/VSLTreeParser.g:400:5: IDENT
			{
			IDENT8=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1460); 

						code3a.append(Code3aGenerator.genDeclVar(symTab, (IDENT8!=null?IDENT8.getText():null)));
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
	// $ANTLR end "decl_item"

	// Delegated rules



	public static final BitSet FOLLOW_expression_in_s69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_s86 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNC_KW_in_function116 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_function123 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_function129 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_param_list_in_function142 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_BODY_in_function160 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_function168 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INT_KW_in_type209 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KW_in_type220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARAM_in_param_list256 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_param_list265 = new BitSet(new long[]{0x0000000000004008L});
	public static final BitSet FOLLOW_PARAM_in_param_list290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_param308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement355 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement359 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement362 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_KW_in_statement448 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement458 = new BitSet(new long[]{0x0000021044008020L});
	public static final BitSet FOLLOW_statement_in_statement480 = new BitSet(new long[]{0x0000021044008028L});
	public static final BitSet FOLLOW_statement_in_statement510 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement570 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement593 = new BitSet(new long[]{0x0000021044008020L});
	public static final BitSet FOLLOW_statement_in_statement617 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement660 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_list_in_statement670 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_KW_in_statement709 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_list_in_statement719 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block767 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block785 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block790 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block817 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block821 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list873 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list887 = new BitSet(new long[]{0x0000021044008028L});
	public static final BitSet FOLLOW_PLUS_in_expression948 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression952 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression957 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression988 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression992 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression997 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression1027 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1031 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1036 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression1066 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1070 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1075 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGAT_in_expression1105 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1109 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression1133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp1167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp1187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_item_in_print_list1231 = new BitSet(new long[]{0x0000800202C14202L});
	public static final BitSet FOLLOW_TEXT_in_print_item1262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item1277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_item_in_read_list1316 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_IDENT_in_read_item1347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECL_in_declaration1387 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_item_in_declaration1398 = new BitSet(new long[]{0x0000000000004008L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1460 = new BitSet(new long[]{0x0000000000000002L});
}
