import numpy as np                              # creates an array object
import collections                              # give you a default value when calling a non exist key
from itertools import chain                     # concatenate an iterable object
from pythainlp.tokenize import word_tokenize    # split a sentence into words

from sklearn.model_selection import KFold             # k-fold cross validation
from sklearn.model_selection import train_test_split  # hold-out validation

from nltk import FreqDist, precision, recall, f_measure, NaiveBayesClassifier   # build and measure a model
from nltk.classify import util                  # use a model

pos_path = 'pos.txt'
neg_path = 'neg.txt'

# read files in the provided paths then remove all spaces at the start and end of a string
# and label each word according to the folder afterwards
raw_data_pos = [[line.strip(), 'pos'] for line in open(pos_path, 'r')]
raw_data_neg = [[line.strip(), 'neg'] for line in open(neg_path, 'r')]

# merge positive and negative dataset into a single dataset
dataset = raw_data_pos + raw_data_neg

print(dataset)

value_set = []
label_set = []

def split_value_label(dataset):
    for value, label in dataset:
        value_set.append(value)
        label_set.append(label)

def merge_value_label(value, label):
    temp_merge = []
    for i in range(len(value)):
        temp_tuple = (value[i], label[i])
        temp_merge.append(temp_tuple)
    # for i in range(len(X_test)):
    # temp_list = list()
    # temp_list.append(X_test[i])
    # temp_list.append(y_test[i])
    # temp_tuple = (X_test[i], y_test[i])
    # test_set_30.append(temp_tuple) # temp_list
    # print(X_test[i], ' | ', y_test[i])
    return temp_merge

# split the data from the label
split_value_label(dataset)

# split train-test
X_train, X_test, y_train, y_test = train_test_split(value_set, label_set, test_size=0.30, random_state=99)

# merge it again as we need to further process it
test_set = merge_value_label(X_test, y_test)
train_set = merge_value_label(X_train, y_train)

# extract words from the sentences using word_tokenize() function
vocabulary = set(chain(*[word_tokenize(i[0].lower()) for i in train_set]))
feature_train_set = [({i:(i in word_tokenize(sentence.lower())) for i in vocabulary},tag) for sentence, tag in train_set]
feature_test_set = [({i:(i in word_tokenize(sentence.lower())) for i in vocabulary},tag) for sentence, tag in test_set]
classifier = NaiveBayesClassifier.train(feature_train_set)

# validating part
refsets = collections.defaultdict(set)
testsets = collections.defaultdict(set)
for i, (feats, label) in enumerate(feature_test_set):
    refsets[label].add(i)
    observed = classifier.classify(feats)
    testsets[observed].add(i)
    accuracy_score = util.accuracy(classifier, feature_test_set)
print('No. of Training Data: {}'.format(len(train_set)))
print('No. of Testing Data: {}'.format(len(test_set)))
print('=================== Results ===================')
print('Accuracy {:f}'.format(accuracy_score))
print('            Positive     Negative')
print('F1         [{:f}     {:f}]'.format(
        f_measure(refsets['pos'], testsets['pos']),
        f_measure(refsets['neg'], testsets['neg'])
))
print('Precision  [{:f}     {:f}]'.format(
        precision(refsets['pos'], testsets['pos']),
        precision(refsets['neg'], testsets['neg'])
))
print('Recall     [{:f}     {:f}]'.format(
        recall(refsets['pos'], testsets['pos']),
        recall(refsets['neg'], testsets['neg'])
))
print('===============================================\n')

# set up a k-fold cross validation
data_k_fold = KFold(n_splits=10, random_state=99, shuffle=True)

# start training a model
for k, (train_set, test_set) in enumerate(data_k_fold.split(dataset)):
    dataset = np.array(dataset)
    train_set = dataset[train_set]
    test_set = dataset[test_set]
    vocabulary = set(chain(*[word_tokenize(i[0]) for i in train_set]))
    feature_train_set = [({i:(i in word_tokenize(sentence)) for i in vocabulary},tag) for sentence, tag in train_set]
    feature_test_set = [({i:(i in word_tokenize(sentence)) for i in vocabulary},tag) for sentence, tag in test_set]
    classifier = NaiveBayesClassifier.train(feature_train_set)  
    refsets = collections.defaultdict(set)
    testsets = collections.defaultdict(set)
    for i, (feats, label) in enumerate(feature_test_set):
        refsets[label].add(i)
        observed = classifier.classify(feats)
        testsets[observed].add(i)
    accuracy_score = util.accuracy(classifier, feature_test_set)
    print('Fold {}'.format(k + 1))
    print('=================== Results ===================')
    print('Accuracy {:f}'.format(accuracy_score))
    print('            Positive     Negative')
    print('F1         [{:f}     {:f}]'.format(
        f_measure(refsets['pos'], testsets['pos']),
        f_measure(refsets['neg'], testsets['neg'])
    ))
    print('Precision  [{:f}     {:f}]'.format(
        precision(refsets['pos'], testsets['pos']),
        precision(refsets['neg'], testsets['neg'])
    ))
    print('Recall     [{:f}     {:f}]'.format(
        recall(refsets['pos'], testsets['pos']),
        recall(refsets['neg'], testsets['neg'])
    ))
    print('===============================================\n')

    while True:
        test_sentence = input('\nTest Sentence: ')
        if test_sentence == '.':
            break
        else:
            featurized_test_sentence =  {i:(i in word_tokenize(test_sentence)) for i in vocabulary}
            print("Tag:",classifier.classify(featurized_test_sentence))