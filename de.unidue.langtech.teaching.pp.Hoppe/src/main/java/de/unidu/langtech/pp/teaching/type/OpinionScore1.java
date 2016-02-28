

/* First created by JCasGen Sun Feb 28 13:03:44 CET 2016 */
package de.unidu.langtech.pp.teaching.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Feb 28 13:03:44 CET 2016
 * XML source: /Users/janahoppe/Documents/TextAnalyticsHoppe/de.unidue.langtech.teaching.pp.Hoppe/src/main/resources/desc/type/OpinionScore1.xml
 * @generated */
public class OpinionScore1 extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(OpinionScore1.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected OpinionScore1() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public OpinionScore1(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public OpinionScore1(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public OpinionScore1(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: opinionScore

  /** getter for opinionScore - gets Speichert die gefundenden und aufaddierten Werte des ersten Wörterbuchs.
   * @generated
   * @return value of the feature 
   */
  public float getOpinionScore() {
    if (OpinionScore1_Type.featOkTst && ((OpinionScore1_Type)jcasType).casFeat_opinionScore == null)
      jcasType.jcas.throwFeatMissing("opinionScore", "de.unidu.langtech.pp.teaching.type.OpinionScore1");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((OpinionScore1_Type)jcasType).casFeatCode_opinionScore);}
    
  /** setter for opinionScore - sets Speichert die gefundenden und aufaddierten Werte des ersten Wörterbuchs. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setOpinionScore(float v) {
    if (OpinionScore1_Type.featOkTst && ((OpinionScore1_Type)jcasType).casFeat_opinionScore == null)
      jcasType.jcas.throwFeatMissing("opinionScore", "de.unidu.langtech.pp.teaching.type.OpinionScore1");
    jcasType.ll_cas.ll_setFloatValue(addr, ((OpinionScore1_Type)jcasType).casFeatCode_opinionScore, v);}    
  }

    