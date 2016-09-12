/*******************************************************************************
 * Copyright 2011-2013 Sergey Tarasevich
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.unversimageloader;

import com.wrapp.example.floatlabelededittext.R;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public final class Constants {

    public static final String[] IMAGES = new String[]{
            // Heavy images
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/1.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/2.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/3.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/4.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/5.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/6.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/7.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/8.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/9.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/10.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/12.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/13.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/14.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/15.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/16.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/17.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/18.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/19.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/20.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/21.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/22.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/23.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/24.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/25.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/26.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/27.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/28.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/29.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/30.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/31.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/32.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/33.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/34.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/35.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/36.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/37.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/38.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/39.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/40.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/41.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/42.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/43.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/44.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/45.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/46.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/47.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/48.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/49.jpg",
            "https://raw.githubusercontent.com/zzzengxiaoxian/MyApp/master/photo/50.jpg",


            // Light images
            "http://ac-apnbvacb.clouddn.com/4054ed6cfbdb6d2d1f46.jpg",
            "http://ac-apnbvacb.clouddn.com/50921dd01247a63740ef.jpg",
            "",
            // Special cases
            "http://cdn.urbanislandz.com/wp-content/uploads/2011/10/MMSposter-large.jpg", // Very large image
            "http://4.bp.blogspot.com/-LEvwF87bbyU/Uicaskm-g6I/AAAAAAAAZ2c/V-WZZAvFg5I/s800/Pesto+Guacamole+500w+0268.jpg", // Image with "Mark has been invalidated" problem
            "file:///sdcard/Universal Image Loader @#&=+-_.,!()~'%20.png", // Image from SD card with encoded symbols
            "assets://Living Things @#&=+-_.,!()~'%20.jpg", // Image from assets
            "drawable://" + R.drawable.ic_launcher, // Image from drawables
            "http://upload.wikimedia.org/wikipedia/ru/b/b6/Как_кот_с_мышами_воевал.png", // Link with UTF-8
            "https://www.eff.org/sites/default/files/chrome150_0. // Redirect linkjpg", // Image from HTTPS
            "http://bit.ly/soBiXr",
            "http://img001.us.expono.com/100001/100001-1bc30-2d736f_m.jpg", // EXIF
            "", // Empty link
            "http://wrong.site.com/corruptedLink", // Wrong link
    };

    private Constants() {
    }

    public static class Config {
        public static final boolean DEVELOPER_MODE = false;
    }

    public static class Extra {
        public static final String IMAGES = "com.nostra13.example.universalimageloader.IMAGES";
        public static final String IMAGE_POSITION = "com.nostra13.example.universalimageloader.IMAGE_POSITION";
    }
}
