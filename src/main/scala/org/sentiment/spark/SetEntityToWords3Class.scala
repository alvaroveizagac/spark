package org.sentiment.spark

import edu.stanford.nlp.ling._
import scala.io.Source
import java.io.BufferedWriter
import java.io.FileWriter
import com.opencsv.CSVWriter


import edu.stanford.nlp.ie.AbstractSequenceClassifier
import edu.stanford.nlp.ie.crf._
import edu.stanford.nlp.io.IOUtils
import edu.stanford.nlp.ling.CoreLabel
import edu.stanford.nlp.ling.CoreAnnotations
import edu.stanford.nlp.sequences.DocumentReaderAndWriter
import edu.stanford.nlp.util.Triple
import java.util.List

import org.apache.spark.SparkFiles
//remove if not needed
import scala.collection.JavaConversions._
import scala.collection.immutable.List
import edu.stanford.nlp.fsm.FastExactAutomatonMinimizer.Split

import scala.collection.mutable.ArrayBuffer

import scala.io.Source

//Stanford NER  Incorporating Non-local Information into Information Extraction Systems by Gibbs Sampling. Proceedings of the 43nd Annual Meeting of the Association for Computational Linguistics (ACL 2005)
// pp. 363-370, pp. 363-370

object SetEntityToWords3Class
{ 
  val classifier:CRFClassifier[CoreLabel] = CRFClassifier. getClassifier(SparkFiles.get(PrParameters.clasEnt3ClassModel))  //Cluster
  def classifyNounsClass(tweet:String) :String =
  {
    var tweetWithoutPos = ""
    if(tweet.startsWith("blktweetpreprocessing") || tweet.startsWith("typostweet") || tweet == "blkless3chars_BT" || tweet == "blklessfreqtweet_BT"  )
    {      
      tweetWithoutPos = tweet+"/O"      
    }else
    {
      var capitalizedTweet:String =  Utils.capitalizeNounsDeletePos(tweet)
      tweetWithoutPos  = classifier.classifyToString(capitalizedTweet, "slashTags", true)
    }   
    return tweetWithoutPos.trim()
  }
  
  def classifyWord(tweet:String, pos:String) :String =
  { 
    var tweetWithoutPos = ""
    if(tweet.startsWith("blktweetpreprocessing") || tweet.startsWith("typostweet") || tweet == "blkless3chars_BT" || tweet == "blklessfreqtweet_BT"  )
    {      
      tweetWithoutPos = tweet+"/O"      
    }else
    {
      var capitalizedTweet:String =  Utils.capitalizeWord(tweet, pos)
      tweetWithoutPos  = classifier.classifyToString(capitalizedTweet, "slashTags", true)
    }   
    return tweetWithoutPos.trim()
  }
}