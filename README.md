# spark
Sentiment Analysis Lexicon based approach

With the rise of Web 2.0, more and more words that are not sentimental are often associated with positive/negative feelings. In the following Apache Spark project we present an approach for extracting and monitoring what we call ephemeral entities from social streams.

The project generates:

  * sentiment analysis (using lexicon-based approach SentiWordNet 3.0 )
  * not lexicon words extraction (generating a dictionary for each month)
  * assigning sentiment to not lexicon words (using methods avg and pmi)
  * applying FEL entities filtering
  * create trajectories of ephemeral entities
  
The dataset should follow the following format using as a separator ",":

  - SENTIMENT_OF_TEXT (positive=4/negative=0/neutral=2)
  - TWEET-ID(long)
  - POST_DATE 
  - TWEET-QUERY
  - USER
  -TWEET (string)

Example:

"0","1550724000","Sat Apr 18 07:04:07 PDT 2009","NO_QUERY","trwiles","Wishing I was going to play golf today. Yard work instead. YAY "

The project was built using Scala 2.10.6 and Spark version 1.6.0 for supporting the distributed computation.

- MainSentiment.scala : Object that is in charge of calling to the different methods for applying the preprocessing, the sentiment analysis tasks and building the dictionaries containing the words that are not part of the lexicon using both methods. It writes the following files as outputs :
  - sentimentDataset.csv: file that contains the dataset after applying the preprocessing and sentiment analysis tasks. The output format uses the character separator ",".
    - dataset sentiment
    - sentiwordnet sentiment
    - tweet after preprocessing
    - no sentiment words + the sentiwordnet sentiment (case tweets)
    - no sentiment words + the dataset sentiment (case tweets)
    - no sentiment words + the sentiwordnet sentiment (case tokens)
    - no sentiment words + the dataset sentiment (case tokens)
    - hashtags words
    - slangs words that come from the first call
    - slangs words that come from the second call
    - list of no frequent words (less than the set threshold)
  - Hashtags.csv (contains the hashtags found during the preprocessing and sentiment analysis tasks)
  - WordsNoSentimentImplComb.csv: (groups the words that are not part of the lexicon along with the sentiment from sentiwordnet case tokens)
  - WordsNoSentimentOrigComb.csv: (groups the words that are not part of the lexicon along with the sentiment from dataset case tokens)
  - WordsNoSentimentImplCombDist.csv: (groups the words that are not part of the lexicon along with the sentiment from sentiwordnet case tweets)
  - WordsNoSentimentOrigCombDist.csv: (groups the words that are not part of the lexicon along with the sentiment from dataset case tweets)
  - AVGSentWordNetTokens.csv: (dictionary of not sentiment words method avg case tokens)
  - AVGSentWordNetTweets.csv: (dictionary of not sentiment words method avg case tweets)
  - SentiWordNetPMITweets.txt: (dictionary of not sentiment words method avg case tweets)
  - SentiWordNetPMITokens.txt: (dictionary of not sentiment words method avg case tokens)
- PrParameters.scala: object that contains the paths of the models, datasets, libraries and other external files necessary for the project
- CombFelEntities.scala: object takes the list of the FEL entities and apply some preprocessing steps */
- BuildTrajectories.scala: object that gathers all dictionaries of not sentiment words, apply some filters i.e. FEl entities as output it writes into a file the ephemeral entities trajectory
