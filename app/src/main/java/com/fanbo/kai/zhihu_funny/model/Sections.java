package com.fanbo.kai.zhihu_funny.model;

import android.os.Parcel;

import com.fanbo.kai.zhihu_funny.model.base.BaseModel;

import java.util.List;

/**
 * Created by HK on 2017/1/24.
 * Email: kaihu1989@gmail.com.
 */

public class Sections extends BaseModel {
    private List<Section> data;

    public List<Section> getData() {
        return data;
    }

    public static class Section implements android.os.Parcelable {
        private int id;
        private String description;
        private String name;
        private String thumbnail;

        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public String getName() {
            return name;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(this.id);
            dest.writeString(this.description);
            dest.writeString(this.name);
            dest.writeString(this.thumbnail);
        }

        public Section() {
        }

        protected Section(Parcel in) {
            this.id = (int) in.readValue(Long.class.getClassLoader());
            this.description = in.readString();
            this.name = in.readString();
            this.thumbnail = in.readString();
        }

        public static final Creator<Section> CREATOR = new Creator<Section>() {
            @Override
            public Section createFromParcel(Parcel source) {
                return new Section(source);
            }

            @Override
            public Section[] newArray(int size) {
                return new Section[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(this.data);
    }

    public Sections() {
    }

    protected Sections(Parcel in) {
        this.data = in.createTypedArrayList(Section.CREATOR);
    }

    public static final Creator<Sections> CREATOR = new Creator<Sections>() {
        @Override
        public Sections createFromParcel(Parcel source) {
            return new Sections(source);
        }

        @Override
        public Sections[] newArray(int size) {
            return new Sections[size];
        }
    };
}
