// $ANTLR 3.5 ./src/VSLTreeParser.g 2015-11-21 02:10:53

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
	// ./src/VSLTreeParser.g:19:1: program[SymbolTable symTab] returns [Code3a code3a] : ^( PROG (u= unit[symTab] )+ ) ;
	public final Code3a program(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a u =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:24:2: ( ^( PROG (u= unit[symTab] )+ ) )
			// ./src/VSLTreeParser.g:26:3: ^( PROG (u= unit[symTab] )+ )
			{
			match(input,PROG,FOLLOW_PROG_in_program105); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:28:4: (u= unit[symTab] )+
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
					// ./src/VSLTreeParser.g:29:5: u= unit[symTab]
					{
					pushFollow(FOLLOW_unit_in_program118);
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
	// ./src/VSLTreeParser.g:37:1: unit[SymbolTable symTab] returns [Code3a code3a] : (f= function[symTab] |p= proto[symTab] );
	public final Code3a unit(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a f =null;
		Code3a p =null;

		try {
			// ./src/VSLTreeParser.g:38:5: (f= function[symTab] |p= proto[symTab] )
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
					// ./src/VSLTreeParser.g:39:6: f= function[symTab]
					{
					pushFollow(FOLLOW_function_in_unit161);
					f=function(symTab);
					state._fsp--;


					    		code3a = f;
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:44:6: p= proto[symTab]
					{
					pushFollow(FOLLOW_proto_in_unit184);
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
	// ./src/VSLTreeParser.g:51:1: proto[SymbolTable symTab] returns [Code3a code3a] : ^( PROTO_KW t= type[symTab] IDENT p= param_list[symTab] ) ;
	public final Code3a proto(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT1=null;
		Type t =null;
		List<VarSymbol> p =null;

		try {
			// ./src/VSLTreeParser.g:52:2: ( ^( PROTO_KW t= type[symTab] IDENT p= param_list[symTab] ) )
			// ./src/VSLTreeParser.g:53:3: ^( PROTO_KW t= type[symTab] IDENT p= param_list[symTab] )
			{
			match(input,PROTO_KW,FOLLOW_PROTO_KW_in_proto221); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_proto228);
			t=type(symTab);
			state._fsp--;

			IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_proto234); 
			pushFollow(FOLLOW_param_list_in_proto241);
			p=param_list(symTab);
			state._fsp--;


							code3a = Code3aGenerator.genFunctionSignature(symTab, (IDENT1!=null?IDENT1.getText():null), t, p, true);
						
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
	// ./src/VSLTreeParser.g:65:1: function[SymbolTable symTab] returns [Code3a code3a] : ^( FUNC_KW t= type[symTab] IDENT p= param_list[symTab] ^( BODY st= statement[symTab] ) ) ;
	public final Code3a function(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT2=null;
		Type t =null;
		List<VarSymbol> p =null;
		Code3a st =null;

		try {
			// ./src/VSLTreeParser.g:66:2: ( ^( FUNC_KW t= type[symTab] IDENT p= param_list[symTab] ^( BODY st= statement[symTab] ) ) )
			// ./src/VSLTreeParser.g:67:3: ^( FUNC_KW t= type[symTab] IDENT p= param_list[symTab] ^( BODY st= statement[symTab] ) )
			{
			match(input,FUNC_KW,FOLLOW_FUNC_KW_in_function276); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_function283);
			t=type(symTab);
			state._fsp--;

			IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function289); 
			pushFollow(FOLLOW_param_list_in_function296);
			p=param_list(symTab);
			state._fsp--;


							code3a = Code3aGenerator.genFunctionSignature(symTab, (IDENT2!=null?IDENT2.getText():null), t, p, false);
						
			match(input,BODY,FOLLOW_BODY_in_function314); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_statement_in_function322);
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
	// ./src/VSLTreeParser.g:91:1: type[SymbolTable symTab] returns [Type typeFunc] : ( INT_KW | VOID_KW );
	public final Type type(SymbolTable symTab) throws RecognitionException {
		Type typeFunc = null;


		try {
			// ./src/VSLTreeParser.g:92:2: ( INT_KW | VOID_KW )
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
					// ./src/VSLTreeParser.g:93:3: INT_KW
					{
					match(input,INT_KW,FOLLOW_INT_KW_in_type363); 

								typeFunc = Type.INT;
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:98:3: VOID_KW
					{
					match(input,VOID_KW,FOLLOW_VOID_KW_in_type374); 

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
	// ./src/VSLTreeParser.g:105:1: param_list[SymbolTable symTab] returns [List<VarSymbol> vars] : ( ^( PARAM (par= param[symTab] )* ) | PARAM );
	public final List<VarSymbol> param_list(SymbolTable symTab) throws RecognitionException {
		List<VarSymbol> vars = null;


		VarSymbol par =null;


				vars = new ArrayList<VarSymbol>();
			
		try {
			// ./src/VSLTreeParser.g:110:2: ( ^( PARAM (par= param[symTab] )* ) | PARAM )
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
					// ./src/VSLTreeParser.g:111:3: ^( PARAM (par= param[symTab] )* )
					{
					match(input,PARAM,FOLLOW_PARAM_in_param_list410); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// ./src/VSLTreeParser.g:112:9: (par= param[symTab] )*
						loop4:
						while (true) {
							int alt4=2;
							int LA4_0 = input.LA(1);
							if ( (LA4_0==IDENT) ) {
								alt4=1;
							}

							switch (alt4) {
							case 1 :
								// ./src/VSLTreeParser.g:113:5: par= param[symTab]
								{
								pushFollow(FOLLOW_param_in_param_list419);
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
					// ./src/VSLTreeParser.g:121:3: PARAM
					{
					match(input,PARAM,FOLLOW_PARAM_in_param_list444); 
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
	// ./src/VSLTreeParser.g:124:1: param[SymbolTable symTab] returns [VarSymbol param] : IDENT ;
	public final VarSymbol param(SymbolTable symTab) throws RecognitionException {
		VarSymbol param = null;


		CommonTree IDENT3=null;

		try {
			// ./src/VSLTreeParser.g:125:2: ( IDENT )
			// ./src/VSLTreeParser.g:126:3: IDENT
			{
			IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param462); 

						param = Code3aGenerator.genParam(symTab, (IDENT3!=null?IDENT3.getText():null));
					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return param;
	}
	// $ANTLR end "param"



	// $ANTLR start "statement"
	// ./src/VSLTreeParser.g:134:1: statement[SymbolTable symTab] returns [Code3a code3a] : ( ^( ASSIGN_KW e1= expression[symTab] IDENT () ) |b= block[symTab] | ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pr= print_list[symTab] ) | ^( READ_KW r= read_list[symTab] ) | ^( RETURN_KW e= expression[symTab] ) );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT4=null;
		CommonTree ASSIGN_KW5=null;
		CommonTree IF_KW6=null;
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
			// ./src/VSLTreeParser.g:139:4: ( ^( ASSIGN_KW e1= expression[symTab] IDENT () ) |b= block[symTab] | ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pr= print_list[symTab] ) | ^( READ_KW r= read_list[symTab] ) | ^( RETURN_KW e= expression[symTab] ) )
			int alt7=7;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt7=1;
				}
				break;
			case BLOCK:
				{
				alt7=2;
				}
				break;
			case IF_KW:
				{
				alt7=3;
				}
				break;
			case WHILE_KW:
				{
				alt7=4;
				}
				break;
			case PRINT_KW:
				{
				alt7=5;
				}
				break;
			case READ_KW:
				{
				alt7=6;
				}
				break;
			case RETURN_KW:
				{
				alt7=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// ./src/VSLTreeParser.g:140:5: ^( ASSIGN_KW e1= expression[symTab] IDENT () )
					{
					ASSIGN_KW5=(CommonTree)match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement509); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement513);
					e1=expression(symTab);
					state._fsp--;

					IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement516); 
					// ./src/VSLTreeParser.g:141:9: ()
					// ./src/VSLTreeParser.g:142:11: 
					{

					          			code3a = Code3aGenerator.genAffExpr(symTab, e1, (IDENT4!=null?IDENT4.getText():null), ASSIGN_KW5);
					        		
					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:150:5: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement571);
					b=block(symTab);
					state._fsp--;


					        	code3a = b;
					    	
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:157:6: ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					IF_KW6=(CommonTree)match(input,IF_KW,FOLLOW_IF_KW_in_statement602); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement612);
					e1=expression(symTab);
					state._fsp--;


					    			LabelSymbol l_else = SymbDistrib.newLabel();
					    			LabelSymbol l_end = SymbDistrib.newLabel();
					    			code3a = Code3aGenerator.genIfStatement(e1, l_else, IF_KW6);
					    		
					pushFollow(FOLLOW_statement_in_statement634);
					s1=statement(symTab);
					state._fsp--;


					    			code3a.append(s1);
					    			code3a.append(Code3aGenerator.genGoTo(l_end));
					    			code3a.append(Code3aGenerator.genLabel(l_else));
					    		
					// ./src/VSLTreeParser.g:172:7: (s2= statement[symTab] )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==ASSIGN_KW||LA6_0==IF_KW||LA6_0==PRINT_KW||(LA6_0 >= READ_KW && LA6_0 <= RETURN_KW)||LA6_0==WHILE_KW||LA6_0==BLOCK) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// ./src/VSLTreeParser.g:173:8: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement664);
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
					// ./src/VSLTreeParser.g:185:7: ^( WHILE_KW e= expression[symTab] st= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement724); 

					          LabelSymbol l_while = SymbDistrib.newLabel();
					          LabelSymbol l_end = SymbDistrib.newLabel();
					        
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement747);
					e=expression(symTab);
					state._fsp--;


					          code3a = Code3aGenerator.genWhileStatement(e, l_end);
					        
					pushFollow(FOLLOW_statement_in_statement771);
					st=statement(symTab);
					state._fsp--;


					          code3a.append(st);
					          code3a.append(Code3aGenerator.genGoTo(l_while));
					        
					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:206:6: ^( PRINT_KW pr= print_list[symTab] )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement814); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_print_list_in_statement824);
					pr=print_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					    		code3a = pr;
					    	
					}
					break;
				case 6 :
					// ./src/VSLTreeParser.g:216:6: ^( READ_KW r= read_list[symTab] )
					{
					match(input,READ_KW,FOLLOW_READ_KW_in_statement863); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_read_list_in_statement873);
					r=read_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        	code3a = r;
					    	
					}
					break;
				case 7 :
					// ./src/VSLTreeParser.g:225:6: ^( RETURN_KW e= expression[symTab] )
					{
					match(input,RETURN_KW,FOLLOW_RETURN_KW_in_statement910); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement920);
					e=expression(symTab);
					state._fsp--;


					    			code3a = Code3aGenerator.genReturn(e);
					    		
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
	// ./src/VSLTreeParser.g:235:1: block[SymbolTable symTab] returns [Code3a code3a] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a d =null;
		Code3a il =null;


		      code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:240:2: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==BLOCK) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==DOWN) ) {
					int LA8_2 = input.LA(3);
					if ( (LA8_2==DECL) ) {
						alt8=1;
					}
					else if ( (LA8_2==INST) ) {
						alt8=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 8, 2, input);
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
							new NoViableAltException("", 8, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// ./src/VSLTreeParser.g:241:3: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block969); 

					      		symTab.enterScope();
					    	
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block987);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block992);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      		code3a = d;
					      		code3a.append(il);
					      		symTab.leaveScope();
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:256:4: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block1019); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block1023);
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
	// ./src/VSLTreeParser.g:263:1: inst_list[SymbolTable symTab] returns [Code3a code3a] : ^( INST (il= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a il =null;


		      	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:268:4: ( ^( INST (il= statement[symTab] )+ ) )
			// ./src/VSLTreeParser.g:269:5: ^( INST (il= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list1075); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:270:10: (il= statement[symTab] )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==ASSIGN_KW||LA9_0==IF_KW||LA9_0==PRINT_KW||(LA9_0 >= READ_KW && LA9_0 <= RETURN_KW)||LA9_0==WHILE_KW||LA9_0==BLOCK) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// ./src/VSLTreeParser.g:271:10: il= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list1089);
					il=statement(symTab);
					state._fsp--;


					        			code3a.append(il);
					      			
					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
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
	// ./src/VSLTreeParser.g:280:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// ./src/VSLTreeParser.g:281:4: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt10=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt10=1;
				}
				break;
			case MINUS:
				{
				alt10=2;
				}
				break;
			case MUL:
				{
				alt10=3;
				}
				break;
			case DIV:
				{
				alt10=4;
				}
				break;
			case IDENT:
			case INTEGER:
				{
				alt10=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// ./src/VSLTreeParser.g:283:6: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression1150); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1154);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1159);
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
					// ./src/VSLTreeParser.g:294:6: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression1190); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1194);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1199);
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
					// ./src/VSLTreeParser.g:305:6: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression1229); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1233);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1238);
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
					// ./src/VSLTreeParser.g:316:6: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression1268); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1272);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1277);
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
					// ./src/VSLTreeParser.g:326:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression1301);
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
	// ./src/VSLTreeParser.g:334:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER7=null;
		CommonTree IDENT8=null;

		try {
			// ./src/VSLTreeParser.g:335:4: ( INTEGER | IDENT )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==INTEGER) ) {
				alt11=1;
			}
			else if ( (LA11_0==IDENT) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// ./src/VSLTreeParser.g:336:5: INTEGER
					{
					INTEGER7=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp1335); 

					      		ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER7!=null?INTEGER7.getText():null)));
					      		expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:344:5: IDENT
					{
					IDENT8=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp1355); 

					      		Operand3a id = symTab.lookup((IDENT8!=null?IDENT8.getText():null));
					      		if(id == null) {
					      			Errors.unknownIdentifier(IDENT8, (IDENT8!=null?IDENT8.getText():null), null);
					      			System.err.println("Compilation terminated");
					      			System.exit(-1);
					      		}
					      		expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT8!=null?IDENT8.getText():null)));
					    	
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
	// ./src/VSLTreeParser.g:357:1: print_list[SymbolTable symTab] returns [Code3a code3a] : (pr_list= print_item[symTab] )+ ;
	public final Code3a print_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a pr_list =null;


		    	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:362:2: ( (pr_list= print_item[symTab] )+ )
			// ./src/VSLTreeParser.g:363:3: (pr_list= print_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:363:3: (pr_list= print_item[symTab] )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==DIV||LA12_0==IDENT||LA12_0==INTEGER||(LA12_0 >= MINUS && LA12_0 <= MUL)||LA12_0==PLUS||LA12_0==TEXT) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// ./src/VSLTreeParser.g:364:4: pr_list= print_item[symTab]
					{
					pushFollow(FOLLOW_print_item_in_print_list1399);
					pr_list=print_item(symTab);
					state._fsp--;


									code3a.append(pr_list);
								
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
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
	// ./src/VSLTreeParser.g:372:1: print_item[SymbolTable symTab] returns [Code3a code3a] : ( TEXT |e= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree TEXT9=null;
		ExpAttribute e =null;

		try {
			// ./src/VSLTreeParser.g:373:2: ( TEXT |e= expression[symTab] )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==TEXT) ) {
				alt13=1;
			}
			else if ( (LA13_0==DIV||LA13_0==IDENT||LA13_0==INTEGER||(LA13_0 >= MINUS && LA13_0 <= MUL)||LA13_0==PLUS) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// ./src/VSLTreeParser.g:374:3: TEXT
					{
					TEXT9=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item1430); 

								code3a = Code3aGenerator.genPrintString((TEXT9!=null?TEXT9.getText():null));	
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:381:3: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item1445);
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
	// ./src/VSLTreeParser.g:388:1: read_list[SymbolTable symTab] returns [Code3a code3a] : (rl= read_item[symTab] )+ ;
	public final Code3a read_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a rl =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:393:2: ( (rl= read_item[symTab] )+ )
			// ./src/VSLTreeParser.g:394:3: (rl= read_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:394:3: (rl= read_item[symTab] )+
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
					// ./src/VSLTreeParser.g:395:4: rl= read_item[symTab]
					{
					pushFollow(FOLLOW_read_item_in_read_list1484);
					rl=read_item(symTab);
					state._fsp--;


									code3a.append(rl);
								
					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
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
	// ./src/VSLTreeParser.g:403:1: read_item[SymbolTable symTab] returns [Code3a code3a] : IDENT ;
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT10=null;

		try {
			// ./src/VSLTreeParser.g:404:2: ( IDENT )
			// ./src/VSLTreeParser.g:405:3: IDENT
			{
			IDENT10=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item1515); 

						code3a = Code3aGenerator.genReadIdent(symTab, (IDENT10!=null?IDENT10.getText():null), IDENT10);
					
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
	// ./src/VSLTreeParser.g:414:1: declaration[SymbolTable symTab] returns [Code3a code3a] : ^( DECL (value= decl_item[symTab] )+ ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a value =null;


		    	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:419:4: ( ^( DECL (value= decl_item[symTab] )+ ) )
			// ./src/VSLTreeParser.g:419:7: ^( DECL (value= decl_item[symTab] )+ )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration1555); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:420:4: (value= decl_item[symTab] )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==IDENT) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// ./src/VSLTreeParser.g:420:5: value= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_declaration1566);
					value=decl_item(symTab);
					state._fsp--;


					      				code3a.append(value);
					    			
					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
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
	// ./src/VSLTreeParser.g:429:1: decl_item[SymbolTable symTab] returns [Code3a code3a] : IDENT ;
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT11=null;


		     	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:434:4: ( IDENT )
			// ./src/VSLTreeParser.g:435:5: IDENT
			{
			IDENT11=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1628); 

						code3a.append(Code3aGenerator.genDeclVar(symTab, (IDENT11!=null?IDENT11.getText():null)));
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



	public static final BitSet FOLLOW_program_in_s69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROG_in_program105 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_unit_in_program118 = new BitSet(new long[]{0x0000000008002008L});
	public static final BitSet FOLLOW_function_in_unit161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_proto_in_unit184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROTO_KW_in_proto221 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_proto228 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_proto234 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_param_list_in_proto241 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_KW_in_function276 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_function283 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_function289 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_param_list_in_function296 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_BODY_in_function314 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_function322 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INT_KW_in_type363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KW_in_type374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARAM_in_param_list410 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_param_list419 = new BitSet(new long[]{0x0000000000004008L});
	public static final BitSet FOLLOW_PARAM_in_param_list444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_param462 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement509 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement513 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement516 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement571 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_KW_in_statement602 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement612 = new BitSet(new long[]{0x00000210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement634 = new BitSet(new long[]{0x00000210C4008028L});
	public static final BitSet FOLLOW_statement_in_statement664 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement724 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement747 = new BitSet(new long[]{0x00000210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement771 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement814 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_list_in_statement824 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_KW_in_statement863 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_list_in_statement873 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_KW_in_statement910 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement920 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block969 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block987 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block992 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block1019 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block1023 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list1075 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list1089 = new BitSet(new long[]{0x00000210C4008028L});
	public static final BitSet FOLLOW_PLUS_in_expression1150 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1154 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1159 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression1190 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1194 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1199 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression1229 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1233 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1238 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression1268 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1272 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1277 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression1301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp1335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp1355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_item_in_print_list1399 = new BitSet(new long[]{0x0000000202C14202L});
	public static final BitSet FOLLOW_TEXT_in_print_item1430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item1445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_item_in_read_list1484 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_IDENT_in_read_item1515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECL_in_declaration1555 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_item_in_declaration1566 = new BitSet(new long[]{0x0000000000004008L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1628 = new BitSet(new long[]{0x0000000000000002L});
}
