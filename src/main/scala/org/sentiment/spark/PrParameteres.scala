package org.sentiment.spark

import scala.io.Codec
import java.nio.charset.CodingErrorAction

/*Object that contains the paths to the necessary files for the project */

object PrParameters {
  
  implicit val codec = Codec("UTF-8")  
  codec.onMalformedInput(CodingErrorAction.REPLACE)
  codec.onUnmappableCharacter(CodingErrorAction.REPLACE)

  var projectFolder = ""
  var projectDataset = ""
  
  var avgLexicon = """/media/alvaro/TI106320W0C/Results_05.30/04_April/Clean/DistantSupAvgTokens.csv"""
  var pmiLexicon = """/media/alvaro/TI106320W0C/ResearchProjectResults/Results_05.30/04_April/Clean/DistantSupervisionPMITokens.csv"""
    
  var clasEnt3Class = """ExternalFiles/english.all.3class.distsim.crf.ser.gz"""
  var clasEnt3ClassModel = "english.all.3class.distsim.crf.ser.gz"  
  var clasEnt7Class = """Classifiers/english.muc.7class.distsim.crf.ser.gz"""
  var clasEnt7ClassModel = "english.muc.7class.distsim.crf.ser.gz"
    
  var listAdjOpp = """ExternalFiles/opposites.txt""" 
  val slangList  = """ExternalFiles/SlangList2016.txt"""    
  val sentiWordNetFile = """ExternalFiles/SentiWordNet_3.0.0_20130122.txt"""
  
  var dictBForm = """Properties/map_properties.xml"""
  val tagModelFile  = """Classifiers/wsj-0-18-left3words-distsim.tagger"""
  val tagModelName  =         "wsj-0-18-left3words-distsim.tagger"
  
  val stopWordsFile = """ExternalFiles/english_stop.txt"""  
  val contractionsFile = """ExternalFiles/contractions_english.txt"""  
  val listTypos = """ExternalFiles/typosBrikbeck.txt"""  
  val listVerbsNegation = """ExternalFiles/verbs.txt"""  
  val listAdjectivesOpposites = """ExternalFiles/opposites.txt"""  
  val thesaurusFile = """ExternalFiles/thesaurus.txt"""
  
  var compBooster = 10.0 //30.0 //20.0 //40.0  //50.0
  var supBooster = 20.0  //60.0 //40.0 //80.0 //100.0
    
  def setProjectDataset(projectDset:String) = 
  {
    this.projectDataset = projectDset    
  }
  
  def setProjectFolder(projectFolder:String) = 
  {
    this.projectFolder = projectFolder
  }
}