package com.example.bhavikvashi.earthquake;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EQDataAdapter extends ArrayAdapter<EQdata>
{

        public EQDataAdapter(Context context, ArrayList<EQdata> arrayList)
        {
            super(context,0,arrayList);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            EQdata eq1=getItem(position);

            if(convertView==null)
            {
                convertView=LayoutInflater.from(getContext()).inflate(R.layout.myeq_layout, parent, false);
            }

            TextView mag=(TextView)convertView.findViewById(R.id.mag);
            TextView city=(TextView)convertView.findViewById(R.id.city);
            TextView city1=(TextView)convertView.findViewById(R.id.citymain);
            TextView date=(TextView)convertView.findViewById(R.id.date);
            TextView time=(TextView)convertView.findViewById(R.id.time);


            DecimalFormat formatter = new DecimalFormat("0.0");
            String output = formatter.format(eq1.getMag());
            mag.setText(output);
            GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();
            int color;
            if(eq1.getMag()>6.5)
            {
                color= ContextCompat.getColor(getContext(), R.color.magnitude1);
                magnitudeCircle.setColor(color);
            }
            else
            {
                color= ContextCompat.getColor(getContext(), R.color.magnitude2);
                magnitudeCircle.setColor(color);
            }

            int index=0;
            String currentCity=eq1.getCity();
            for(int i=0;i<currentCity.length() -1 ;i++) {
                if (currentCity.charAt(i) == 'o' && currentCity.charAt(i + 1) == 'f') {
                    index = i;
                }
            }

            if(index!=0) {
                String citytodisplay = currentCity.substring(0, index + 2);
                city.setText(citytodisplay);
                citytodisplay=currentCity.substring(index+3);
                city1.setText(citytodisplay);

            }
            else
            {
                city.setVisibility(View.INVISIBLE);
                city1.setText(currentCity);
            }


            long timeInMilliseconds = eq1.getDate();
            Date dateObject = new Date(timeInMilliseconds);
            SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
            String dateToDisplay = dateFormatter.format(dateObject);
            date.setText(dateToDisplay);
            dateFormatter = new SimpleDateFormat("HH:MM");
            String timeToDisplay = dateFormatter.format(dateObject);
            time.setText(timeToDisplay);

            return convertView;
        }
}

