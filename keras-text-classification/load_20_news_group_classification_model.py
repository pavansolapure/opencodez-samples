import pandas as pd
import numpy as np
import pickle
from keras.preprocessing.text import Tokenizer
from keras.models import Sequential, load_model
from pathlib import Path

# For reproducibility
np.random.seed(1237)

# These are the labels we stored from our training
# The order is very important here.

labels = np.array(['alt.atheism', 'comp.graphics', 'comp.os.ms-windows.misc',
 'comp.sys.ibm.pc.hardware', 'comp.sys.mac.hardware', 'comp.windows.x',
 'misc.forsale', 'rec.autos', 'rec.motorcycles', 'rec.sport.baseball',
 'rec.sport.hockey', 'sci.crypt', 'sci.electronics', 'sci.med', 'sci.space',
 'soc.religion.christian', 'talk.politics.guns', 'talk.politics.mideast',
 'talk.politics.misc', 'talk.religion.misc'])

# load our saved model
model = load_model('my_model.h5')

# load tokenizer
tokenizer = Tokenizer()
with open('tokenizer.pickle', 'rb') as handle:
    tokenizer = pickle.load(handle)

test_files = ["C:\\DL\\20news-bydate\\20news-bydate-test\\comp.graphics\\38758",
              "C:\\DL\\20news-bydate\\20news-bydate-test\\misc.forsale\\76115",
              "C:\\DL\\20news-bydate\\20news-bydate-test\\soc.religion.christian\\21329"
              ]
x_data = []
for t_f in test_files:
    t_f_data = Path(t_f).read_text()
    x_data.append(t_f_data)

x_data_series = pd.Series(x_data)
x_tokenized = tokenizer.texts_to_matrix(x_data_series, mode='tfidf')

i=0
for x_t in x_tokenized:
    prediction = model.predict(np.array([x_t]))
    predicted_label = labels[np.argmax(prediction[0])]
    print("File ->", test_files[i], "Predicted label: " + predicted_label)
    i += 1

