

/* First created by JCasGen Thu Jan 07 21:16:38 CET 2016 */
package de.unidu.langtech.pp.teaching.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu Jan 07 21:16:38 CET 2016
 * XML source: /Users/janahoppe/Documents/TextAnalyticsHoppe/de.unidue.langtech.teaching.pp.Hoppe/src/main/resources/desc/type/OpinionFinding.xml
 * @generated */
public class OpinionFinding extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(OpinionFinding.class);
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
  protected OpinionFinding() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public OpinionFinding(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public OpinionFinding(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public OpinionFinding(JCas jcas, int begin, int end) {
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
  //* Feature: opinionFound

  /** getter for opinionFound - gets 
   * @generated
   * @return value of the feature 
   */
  public String getOpinionFound() {
    if (OpinionFinding_Type.featOkTst && ((OpinionFinding_Type)jcasType).casFeat_opinionFound == null)
      jcasType.jcas.throwFeatMissing("opinionFound", "de.unidu.langtech.pp.teaching.type.OpinionFinding");
    return jcasType.ll_cas.ll_getStringValue(addr, ((OpinionFinding_Type)jcasType).casFeatCode_opinionFound);}
    
  /** setter for opinionFound - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setOpinionFound(String v) {
    if (OpinionFinding_Type.featOkTst && ((OpinionFinding_Type)jcasType).casFeat_opinionFound == null)
      jcasType.jcas.throwFeatMissing("opinionFound", "de.unidu.langtech.pp.teaching.type.OpinionFinding");
    jcasType.ll_cas.ll_setStringValue(addr, ((OpinionFinding_Type)jcasType).casFeatCode_opinionFound, v);}    
  }

    