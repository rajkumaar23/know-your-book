package io.github.rajkumaar23.getyourbook;

public class Book {
    private String mAuthorName;
    private String mBookName;
    private String mRating;
    private String mBuyUrl;

    public Book(String AuthorName,String BookName,String rating,String buyUrl)
    {
        mAuthorName=AuthorName;
        mBookName=BookName;
        mRating=rating;
        mBuyUrl=buyUrl;
    }

    public String getmBuyUrl() {
        return mBuyUrl;
    }

    public String getmRating() {
        return mRating;
    }

    public String getmAuthorName() {
        return mAuthorName;
    }

    public String getmBookName() {
        return mBookName;
    }
}
