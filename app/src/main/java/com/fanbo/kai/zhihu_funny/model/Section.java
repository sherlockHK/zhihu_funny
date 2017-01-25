package com.fanbo.kai.zhihu_funny.model;

import android.os.Parcel;

import com.fanbo.kai.zhihu_funny.model.base.BaseModel;

import java.util.Date;
import java.util.List;

/**
 * Created by HK on 2017/1/25.
 * Email: kaihu1989@gmail.com.
 */
public class Section extends BaseModel{
    private String name;
    private int timestamp;
    private List<Story> stories;

    public List<Story> getStories() {
        return stories;
    }

    public static class Story implements android.os.Parcelable {
        private int id;
        private Date date;
        private String display_date;
        private String title;
        private List<String> images;

        public int getId() {
            return id;
        }

        public Date getDate() {
            return date;
        }

        public String getDisplay_date() {
            return display_date;
        }

        public String getTitle() {
            return title;
        }

        public List<String> getImages() {
            return images;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeLong(this.date != null ? this.date.getTime() : -1);
            dest.writeString(this.display_date);
            dest.writeString(this.title);
            dest.writeStringList(this.images);
        }

        public Story() {
        }

        protected Story(Parcel in) {
            this.id = in.readInt();
            long tmpDate = in.readLong();
            this.date = tmpDate == -1 ? null : new Date(tmpDate);
            this.display_date = in.readString();
            this.title = in.readString();
            this.images = in.createStringArrayList();
        }

        public static final Creator<Story> CREATOR = new Creator<Story>() {
            @Override
            public Story createFromParcel(Parcel source) {
                return new Story(source);
            }

            @Override
            public Story[] newArray(int size) {
                return new Story[size];
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
        dest.writeString(this.name);
        dest.writeInt(this.timestamp);
        dest.writeTypedList(this.stories);
    }

    public Section() {
    }

    protected Section(Parcel in) {
        this.name = in.readString();
        this.timestamp = in.readInt();
        this.stories = in.createTypedArrayList(Story.CREATOR);
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
