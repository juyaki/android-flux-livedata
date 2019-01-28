# Android Flux Livedata Sample
This is a very simple sample app using Flux architecture with Jetpack's LiveData and ViewModel. :rocket:

### Architecture used
Because an image is worth a thousand words, and you are too busy to read one thousand words:
![FluxLiveData](https://i.imgur.com/PNV5A3H.png)

### Move it move it
- Clicks on `-1` button will dispatch a `DecreaseCounter` action
- Clicks on `+1` button will dispatch a `IncreaseCounter` action
- `-1` button is enabled only if `state.counter > 0` to avoid having negative counter

![Sample](https://media.giphy.com/media/9G1pA0Eo6O5VWHAd8E/giphy.gif)
