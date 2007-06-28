/* Generated By:JavaCC: Do not edit this line. AssociationNameParser.java */
/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.clazz.parser.association.name;

import java.io.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.diagram.parser.*;
import org.eclipse.uml2.diagram.parser.lookup.LookupSuite;
import org.eclipse.uml2.uml.*;

public class AssociationNameParser extends ExternalParserBase implements AssociationNameParserConstants {
        private Association mySubject;

    public AssociationNameParser(){
        this(new StringReader("")); //$NON-NLS-1$
    }

    public AssociationNameParser(LookupSuite lookup){
        this();
        setLookupSuite(lookup);
    }

        public EClass getSubjectClass(){
                return UMLPackage.eINSTANCE.getAssociation();
        }

        public void parse(EObject target, String text) throws ExternalParserException {
                checkContext();
                ReInit(new StringReader(text));
                mySubject = (Association)target;
                Declaration();
                mySubject = null;
        }

        protected static int parseInt(Token t) throws ParseException {
                if (t.kind != AssociationNameParserConstants.INTEGER_LITERAL){
                        throw new IllegalStateException("Token: " + t + ", image: " + t.image); //$NON-NLS-1$ //$NON-NLS-2$
                }
                try {
                        return Integer.parseInt(t.image); //XXX: "0005", "99999999999999999999999"
                } catch (NumberFormatException e){
                        throw new ParseException("Not supported integer value:" + t.image); //$NON-NLS-1$
                }
        }

  final public void Declaration() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SLASH:
      IsDerived();
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    AssociationName();
    jj_consume_token(0);
  }

  final public void AssociationName() throws ParseException {
        String name;
    name = NameWithSpaces();
                mySubject.setName(name);
  }

  final public void IsDerived() throws ParseException {
    jj_consume_token(SLASH);
                  mySubject.setIsDerived(true);
  }

  final public String NameWithSpaces() throws ParseException {
        StringBuffer result = new StringBuffer();
        Token t;
    t = jj_consume_token(IDENTIFIER);
                                   result.append(t.image);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      t = jj_consume_token(IDENTIFIER);
                                     result.append(' '); result.append(t.image);
    }
                {if (true) return result.toString();}
    throw new Error("Missing return statement in function"); //$NON-NLS-1$
  }

  public AssociationNameParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[2];
  static private int[] jj_la1_0;
  static {
      jj_la1_0();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x8,0x4000000,};
   }

  public AssociationNameParser(java.io.InputStream stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new AssociationNameParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  public AssociationNameParser(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new AssociationNameParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  public AssociationNameParser(AssociationNameParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  public void ReInit(AssociationNameParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[29];
    for (int i = 0; i < 29; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 2; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 29; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

}
