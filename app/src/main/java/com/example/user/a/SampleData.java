package com.example.user.a;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 2017-06-21.
 */

public class SampleData implements Parcelable {

    private static final long serialVersionUID = 1000000L;

    private int mIntData = 28;
    private String mStrData = "Yummy Yummy Goguma!";

    public int getIntData() {
        return mIntData;
    }

    public void setIntData(int intData) {
        this.mIntData = intData;
    }

    public String getStrData() {
        return mStrData;
    }

    public void setStrData(String strData) {
        this.mStrData = strData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        // 송신측 사용 함수
        parcel.writeInt(mIntData);
        parcel.writeString(mStrData);
    }

    public static final Parcelable.Creator<SampleData> CREATOR =
            new Creator<SampleData>() {
                // 수신측 사용 함수
                @Override
                public SampleData createFromParcel(Parcel parcel) {

                    SampleData sampleData = new SampleData();
                    sampleData.setIntData(parcel.readInt());
                    sampleData.setStrData(parcel.readString());

                    return sampleData;
                }

                @Override
                public SampleData[] newArray(int i) {
                    return null;
                }
            };

}
