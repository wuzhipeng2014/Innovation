#coding: utf-8

from numpy import *
import operator

def creatDataSet():
    group=array([[1.0, 1.1], [1.0, 1.0], [0, 0], [0, 0.1] ])
    labels=['A', 'A', 'B', 'B']
    print group
    print labels
    return group, labels
creatDataSet()
print 'test'
print 'idea运行Python也是非常棒的!!!'
