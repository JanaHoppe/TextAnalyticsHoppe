

/* First created by JCasGen Thu Jan 07 10:31:31 CET 2016 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu Jan 07 10:31:31 CET 2016
 * XML source: /Users/janahoppe/Documents/TextAnalyticsHoppe/de.unidue.langtech.teaching.pp.Hoppe/src/main/resources/desc/type/TweetOpinion.xml
 * @generated */
public class TweetOpinion extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TweetOpinion.class);
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
  protected TweetOpinion() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public TweetOpinion(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public TweetOpinion(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public TweetOpinion(JCas jcas, int begin, int end) {
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
  //* Feature: opinion

  /** getter for opinion - gets 
   * @generated
   * @return value of the feature 
   */
  public String getOpinion() {
    if (TweetOpinion_Type.featOkTst && ((TweetOpinion_Type)jcasType).casFeat_opinion == null)
      jcasType.jcas.throwFeatMissing("opinion", "de.unidue.langtech.teaching.pp.type.TweetOpinion");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TweetOpinion_Type)jcasType).casFeatCode_opinion);}
    
  /** setter for opinion - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setOpinion(String v) {
    if (TweetOpinion_Type.featOkTst && ((TweetOpinion_Type)jcasType).casFeat_opinion == null)
      jcasType.jcas.throwFeatMissing("opinion", "de.unidue.langtech.teaching.pp.type.TweetOpinion");
    jcasType.ll_cas.ll_setStringValue(addr, ((TweetOpinion_Type)jcasType).casFeatCode_opinion, v);}    
  }

    