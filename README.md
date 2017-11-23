[![License](https://img.shields.io/badge/license-Apache--2.0-green.svg)](https://github.com/MarinaShaposhnikova/OnetoFouragain/blob/master/LICENSE)

# OnetoFouragain

A small library for display some images in perfect order 
from one to four and again.

<img src="screenshots/sample.png?raw=true" alt="" width="240"/>

## Usage
### Create a layout in xml, give it the dimensions and count of images
```xml
    <com.meier.marina.library.OnetoFouragainLayout
      android:id="@+id/layout"
      android:layout_width="match_parent"
     android:layout_height="300dp"
     android:orientation="vertical"
     app:countImages="5"/>
```

### Also you can set count of images dynamically
```java
    OnetoFouragainLayout layout = findViewById(R.id.layout);
    layout.setSize(5);
```

#### You can get all imageViews and do everything with them
```java
    for (ImageView image : layout.getImages()) {
        image.setBackgroundColor(Color.parseColor("800000"));
    }
```


See [sample](sample/src/main/java/com/onetofouragain/MainActivity.java).

License
-----

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
