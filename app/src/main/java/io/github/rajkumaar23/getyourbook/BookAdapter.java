package io.github.rajkumaar23.getyourbook;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    public BookAdapter(Context context, List<Book> books)
    {
        super(context,0,books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.book_list_item,parent,false);
        }
        Book currentBook=getItem(position);
        TextView author=(TextView)listItemView.findViewById(R.id.author_name);
        author.setText(currentBook.getmAuthorName());
        TextView book=(TextView)listItemView.findViewById(R.id.book_name);
        book.setText(currentBook.getmBookName());
        TextView rating=(TextView) listItemView.findViewById(R.id.rating_value);
        rating.setText(currentBook.getmRating());
        GradientDrawable magnitudeCircle = (GradientDrawable) rating.getBackground();
        double val;
        try {
            val=Double.parseDouble(currentBook.getmRating());

        }catch (NumberFormatException e){
            val=0.0;
        }
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(val);
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return listItemView;
    }
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
