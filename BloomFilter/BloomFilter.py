__author__ = 'Vamshi'

#  ->   Implementation of a bloom filter for strings of a fixed size (10 characters).
#  ->   Produces two charts for the two hash functions where the x-axis has number of
#       randomly inserted  strings (100, 1000, 10000, 100000, 1 million) and y-axis has number of false positives for the
#       input set of strings from InputData.txt.

import numpy as np
import string
import random
import matplotlib.pyplot as plt


def djb2(hash1, text):
    """
    This function gives the calculated hash value based on input text and hash (magic constant).
    Module of 1000 has to be calculated which gives the bit to be set to 1 in Bloom Filter.
    ord(ch) gives the ASCII value of the character. Even the pointers in C language give the same ASCII value.
    Parameters:
    -----------
    hash1 - Input hash value (there are totally 8 values)
    text  - Input String (length = 10 for our assignment)
    Returns:
    --------
    hash1 - Calculated hash value
    """
    text = list(text)
    for i in range(len(text)):
        hash1 = ((hash1 << 5) + hash1) + ord(text[i])
    return hash1


def sdbm(hash1, text):
    """
    This function gives the calculated hash value based on input text and hash (magic constant).
    Module of 1000 has to be calculated which gives the bit to be set to 1 in Bloom Filter.
    ord(ch) gives the ASCII value of the character. Even the pointers in C language give the same ASCII value.
    Parameters:
    -----------
    hash1 - Input hash value (there are totally 8 values)
    text  - Input String (length = 10 for our assignment)
    Returns:
    --------
    hash1 - Calculated hash value
    """
    for i in range(len(text)):
        hash1 = ord(text[i]) + (hash1 << 6) + (hash1 << 16) - hash1
    return hash1


def main(type_of_hash_func):
    """
    This function implements the bloom filter using the type of hash function it gets from the main function.
    Produces the chart for the hash function where the x-axis has number of
    randomly inserted  strings (100, 1000, 10000, 100000, 1 million) and y-axis has number of false positives for the
    input set of strings from InputData.txt
    Parameters:
    -----------
    type_of_hash_func - either "djb2" or "sdbm"
    """
    m = 1000
    no_of_strings = [100, 1000, 10000, 100000, 1000000]
    random_list_of_strings = []

    # Loading input data
    inputdata = np.loadtxt('InputData.txt', str, '%s')

    # Initializing Bloom Filter bits to zero.
    bloomfilter = np.zeros((m,), dtype=np.int)

    # Generating random 8 values and storing in hash_list
    hash_list = []
    for i in range(8):
        hash_list.append(random.randrange(1000, 8000))

    false_positive_list = []

    # Iterate over [100, 1000, 10000, 100000, 1000000]
    for i in range(len(no_of_strings)):
        # Initializing all the bits of Bloom Filter to 0's
        temp_bloomfilter = bloomfilter
        # Generating the random strings of length 10.
        for j in range(no_of_strings[i]):
            random_list_of_strings.append(''.join(random.choice(string.ascii_lowercase) for k in range(10)))

        # Setting the bloom filter bits to 1 using the hash functions djb2() or sdbm() which is based on
        # the type_of_hash_func variable.
        for p in range(len(random_list_of_strings)):
            for q in range(8):
                if type_of_hash_func == "djb2":
                    bloomfilter_index = djb2(hash_list[q], random_list_of_strings[p]) % m
                elif type_of_hash_func == "sdbm":
                    bloomfilter_index = sdbm(hash_list[q], random_list_of_strings[p]) % m
                temp_bloomfilter[bloomfilter_index] = 1
        print "\n"
        print "Bloom Filter after considering " + str(no_of_strings[i]) + " strings: \n"
        print temp_bloomfilter

        # Calculating number of false positives for the input data using the hash functions djb2() or sdbm()
        # which is based on the type_of_hash_func variable.
        no_of_false_positives = 0
        for j in range(len(inputdata)):
            false_positive = 'Y'    # Flag to check False Positive.
            for q in range(8):
                if type_of_hash_func == "djb2":
                    bloomfilter_index = djb2(hash_list[q], inputdata[j]) % m
                elif type_of_hash_func == "sdbm":
                    bloomfilter_index = sdbm(hash_list[q], inputdata[j]) % m
                if temp_bloomfilter[bloomfilter_index] == 0:
                    false_positive = 'N'
                    break
            if false_positive == 'Y':
                no_of_false_positives += 1

        print "Number of False Positives - " + str(no_of_false_positives)
        false_positive_list.append(no_of_false_positives)

    # Generating and saving the plot
    # X-Axis -> has number of  randomly inserted  strings (100, 1000, 10000, 100000, 1 million)
    # Y-Axis -> number of false positives
    n_groups = 5
    index = np.arange(n_groups)
    bar_width = 0.5
    rects1 = plt.bar(index, false_positive_list, bar_width, color='b')
    plt.xlabel('Number of Randomly Inserted Strings')
    plt.ylabel('Number of Input Set of Strings')
    plt.title('Bloom Filter - False Positives')
    plt.xticks(index + bar_width / 2, no_of_strings)
    plt.savefig(str(type_of_hash_func + ".png"), dpi=None, facecolor='w', edgecolor='w',
                orientation='portrait', papertype=None, format=None,
                transparent=False, bbox_inches=None, pad_inches=0.1,
                frameon=None)

# Main entrance of the Bloom Filter program.
if __name__ == '__main__':

    # Function to perform "djb2" hashing
    main("djb2")

    # Function to perform "sdbm" hashing
    main("sdbm")