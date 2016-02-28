

/* First created by JCasGen Sun Feb 28 13:02:42 CET 2016 */
package de.unidu.langtech.pp.teaching.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Feb 28 13:03:22 CET 2016
 * XML source: /Users/janahoppe/Documents/TextAnalyticsHoppe/de.unidue.langtech.teaching.pp.Hoppe/src/main/resources/desc/type/OpinionScore2.xml
 * @generated */
public class OpinionScore2 extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(OpinionScore2.class);
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
  protected OpinionScore2() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public OpinionScore2(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public OpinionScore2(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public OpinionScore2(JCas jcas, int begin, int end) {
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

  /** getter for opinionScore - gets Speichert die gefundenen und aufaddierten Werte des zweiten Wörterbuchs. 
   * @generated
   * @return value of the feature 
   */
  public float getOpinionScore() {
    if (OpinionScore2_Type.featOkTst && ((OpinionScore2_Type)jcasType).casFeat_opinionScore == null)
      jcasType.jcas.throwFeatMissing("opinionScore", "de.unidu.langtech.pp.teaching.type.OpinionScore2");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((OpinionScore2_Type)jcasType).casFeatCode_opinionScore);}
    
  /** setter for opinionScore - sets Speichert die gefundenen und aufaddierten Werte des zweiten Wörterbuchs.  
   * @generated
   * @param v value to set into the feature 
   */
  public void setOpinionScore(float v) {
    if (OpinionScore2_Type.featOkTst && ((OpinionScore2_Type)jcasType).casFeat_opinionScore == null)
      jcasType.jcas.throwFeatMissing("opinionScore", "de.unidu.langtech.pp.teaching.type.OpinionScore2");
    jcasType.ll_cas.ll_setFloatValue(addr, ((OpinionScore2_Type)jcasType).casFeatCode_opinionScore, v);}    
  }

    