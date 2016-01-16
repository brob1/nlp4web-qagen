# nlp4web-qagen
Project: generate multiplie choice answers for given question and answer.

## Tasks
- [ ] Create configuration system for specifying paths and user accounts (e.g. for the database)
- [ ] Create question sets
  - [ ] IB / Set 1 [Tobias R.]
  - [ ] Set 2 [Max]
  - [x] [Set 3](https://github.com/Thylossus/nlp4web-qagen/blob/master/qagen/src/main/resources/questions/questions-tobiask.txt) [Tobias K.]
  - [x] [Set 4](https://github.com/Thylossus/nlp4web-qagen/blob/master/qagen/src/main/resources/questions/questions-frank-set4.txt) [Frank]
- [ ] Implementation
  - [ ] Answer candidate UIMA type with tag cloud feature (see [#1](https://github.com/Thylossus/nlp4web-qagen/issues/1))
  - [ ] [Open Trivia QA parser](https://github.com/Thylossus/nlp4web-qagen/blob/master/qagen/src/main/java/input/OpenTriviaQAParser.java)
  - [ ] [Keyword extraction](https://github.com/Thylossus/nlp4web-qagen/blob/master/qagen/src/main/java/question/processing/KeywordExtraction.java) for parsed questions
  - [ ] [Category and hypernym detection](https://github.com/Thylossus/nlp4web-qagen/blob/master/qagen/src/main/java/tag/cloud/enrichment/CategoryAndHypernymDetection.java) [Tobias R.]
    - [ ] [Category search](https://github.com/Thylossus/nlp4web-qagen/blob/master/qagen/src/main/java/tag/cloud/enrichment/CategorySearch.java) using [JWPL](https://dkpro.github.io/dkpro-jwpl/)
    - [ ] [Hypernym search](https://github.com/Thylossus/nlp4web-qagen/blob/master/qagen/src/main/java/tag/cloud/enrichment/HypernymSearch.java) usin [JWI](https://projects.csail.mit.edu/jwi/)
  - [ ] [Category ranking](https://github.com/Thylossus/nlp4web-qagen/blob/master/qagen/src/main/java/candidate/extraction/CategoryRanking.java) [Tobias K.] 
  - [ ] [Candidate extraction](https://github.com/Thylossus/nlp4web-qagen/blob/master/qagen/src/main/java/candidate/extraction/CandidateExtraction.java) [Tobias K.]
  - [ ] [Synonym resolution](https://github.com/Thylossus/nlp4web-qagen/blob/master/qagen/src/main/java/candidate/extraction/SynonymResolution.java)
  - [ ] [Similarity detection](https://github.com/Thylossus/nlp4web-qagen/blob/master/qagen/src/main/java/similarity/detection/SimilarityDetection.java)
  - [ ] [Candidate selection](https://github.com/Thylossus/nlp4web-qagen/blob/master/qagen/src/main/java/consumer/CandidateSelection.java)
  - [ ] The pipeline
- [ ] Devlop evaluation formula for tests results
- [ ] Analyze and summarize test results
- [ ] Write final report
- [ ] Create final presentation
