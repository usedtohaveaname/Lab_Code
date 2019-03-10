import numpy as np
import copy
import matplotlib.pyplot as plt
import perceptron as pt
mean = [0, 0]
cov = [[5,0],[0,5]]
x, y = np.random.multivariate_normal(mean, cov, 100).T
plt.plot(x, y, 'x')
plt.axis('equal')
data1 = []
for i in range(100):
    data1.append([[x[i],y[i]],1])
mean = [5, 10]
cov = [[5,0],[0,5]]
x, y = np.random.multivariate_normal(mean, cov, 100).T
data2 = []
for i in range(100):
    data2.append([[x[i],y[i]],-1])
dataTr = copy.copy(data1)
dataTr += data2
np.random.shuffle(dataTr)
dataTest = dataTr[:40]
dataTr = dataTr[40:]

plt.plot(x, y, 'x')
plt.axis('equal')
#plt.show()


_perceptron = pt.Perceptron(2)
vectors = []
labels = []
for i in range(len(dataTr)):
    vectors.append(dataTr[0])
    labels.append(dataTr[1])
_perceptron.forward([0,1])
for i in range(20):
    _perceptron.train(vectors, labels)
print(_perceptron.w)

correct = 0
for i in range(len(dataTest)):
    vectors.append(dataTest[0])
    labels.append(dataTest[1])
    if(_perceptron.forward(dataTest[0]) == dataTest[1]):
        correct += 1
print(correct,'/',len(dataTest))
#_perceptron.forward([0,1])
#_perceptron.train(vectors, labels)
print(_perceptron.w)
