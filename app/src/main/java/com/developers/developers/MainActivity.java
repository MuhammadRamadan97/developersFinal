package com.developers.developers;


import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ListActivity
{
   // names
    private String[] listview_names =  {"Slimane Salim","Saif Amer","Ben Djamaa Ibrahim","Amer Tamari","Muhammad Ramadan"
            ,"Heba Farouk","Haron Al-kahtani","Samah Ahmad Makki","Doaa Saleh",
            "Youssef Essam Morsey","Rami Saad","Duaa Alqurashi","Ahmed Magdy Elsaeed",
            "Hamza Maouni","Tahany Mahmoud","Abdulwahab Abdulhadi","Yasser Mohamed",
            "Mohamed Sobhy","Mohammad Sabri Issa Alamouri","Mustafa HagMusa","Mashael Alahemed", "Anan Al Jadani",
           "Reham Mahmoud", "Rached Alaya", "Mahmoud El jawsagy" };
   //emailes
    private String[] listview_emails = {"shara.admo@gmail.com","seif.ealaan@gmail.com",
            "ibrahimbendjamaa@gmail.com ","amer.tamari@alsammy.com","mohammed.ramadan.glal@gmail.com","heba_hf@yahoo.com",
            "harown12@gmail.com","samahmakki91@gmail.com","doaalgendy@gmail.com","yosfessam2010@yahoo.com",
            "rami.saad055@gmail.com","Duaaalqurashig@gmail.com","a.magdy20002001@gmail.com",
            "hamzamani0606@gmail.com","tahany.mahmoud06@gmail.com","abdulwahab.abdulhadi.95@gmail.com",
            "yasser2010_eg@yahoo.com","mohamed.sobhy.abdelmageed@outlook.com","mohammad.alamouri@gmail.com",
           "abuelsafe@hotmail.com","programmer.500@hotmail.com","Anantech94@gmail.com",
   "ph_a_r@yahoo.com", "rached.alaya@gmail.com", "mahmoudragab0809@gmail.com"};
   //linkedin accounts
    private String[] listview_linkedin = {"https://www.linkedin.com/in/mdeveloppeur","https://www.linkedin.com/in/saif-amer-851414125/",
            "https://www.linkedin.com/in/ibrahim-bendjamaa-5a3930168/","https://linkedin.com/in/AmerTamari",
           "https://www.linkedin.com/in/muhammad-ramadan-9b97b091",
            //something wrong at heba farouk likedin
             " ",
            "https://www.linkedin.com/in/haron-al-kahtani-017881169","https://www.linkedin.com/in/samahmakki",
            "https://www.linkedin.com/in/doaa-saleh-519a44170/","https://www.linkedin.com/in/youssef-essam-204114144",
            "https://www.linkedin.com/in/rami-saad-32b853164/","https://www.linkedin.com/in/duaa-alqurashi-3bb12616a/",
            "https://www.linkedin.com/in/ahmed-magdy-0b783216b/","https://www.linkedin.com/in/hamza-maouni-1bb4a6127",
            "https://www.linkedin.com/in/tahany-mahmoud-b6a87322/","https://www.linkedin.com/in/abdulwahab-abdulhadi",
            "https://www.linkedin.com/in/yasser-hassaan-5b04a6b2","https://www.linkedin.com/in/mohamdsobhy/",

            "https://www.linkedin.com/in/mohammad-alamouri-694b4331","https://www.linkedin.com/in/mustafa-hag-musa-scada-eng/"
    ,"https://www.linkedin.com/in/mashael-al-/ahmad-1bb3a990","https://www.linkedin.com/in/anan-aljadani-091913165/",
   //wrong link with reham likedin
    "",
   "https://www.linkedin.com/in/rached-alaya-/876b9112","https://www.linkedin.com/in/mahmoud-el-jawsagy-8891a315b"};

    static Context mcontext;

    // images
    private static int[] listview_images =
            {
                    R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.amertamari,R.drawable.image4,R.drawable.image5,R.drawable.image6,
                    R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10,R.drawable.image11,R.drawable.image12,
                    R.drawable.image13,R.drawable.image14,R.drawable.image15,R.drawable.image16,R.drawable.image17,R.drawable.image18,
                    R.drawable.image19,R.drawable.image20,R.drawable.image21,R.drawable.image22, R.drawable.image23,R.drawable.image24};


private ListView lv;
private static ArrayList<String> array_sort;
    private static ArrayList<String> array_sort1;
    private static ArrayList<String> array_sort2;

    private static ArrayList<Integer> image_sort;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(android.R.id.list);

        array_sort=new ArrayList<String> (Arrays.asList(listview_names));
        array_sort1=new ArrayList<String> (Arrays.asList(listview_emails));
        array_sort2=new ArrayList<String> (Arrays.asList(listview_linkedin));

        image_sort=new ArrayList<Integer>();
        for (int index = 0; index < listview_images.length; index++)
        {
            image_sort.add(listview_images[index]);
        }
        setListAdapter(new bsAdapter(this));

        lv.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0,
                                    View arg1, int position, long arg3)
            {

                Intent browserIntent = new Intent(getApplicationContext(),WebViewActivity.class);
                browserIntent.putExtra("url",array_sort2.get(position));
                startActivity(browserIntent);
            }
        });
        /*
        Buttons programming
         */
        Button programmingTeam = (Button) findViewById(R.id.programming_team);
        Button xmlTeam = (Button) findViewById(R.id.xml_team);
        Button designingTeam = (Button) findViewById(R.id.designing_team);

        programmingTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Programmers.class);
                intent.putExtra("id", 0);
                startActivity(intent);
            }
        });

        xmlTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), XmlTeam.class);
                intent.putExtra("id", 1);
                startActivity(intent);
            }
        });

        designingTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Designers.class);
                intent.putExtra("id" , 2);
                startActivity(intent);
            }
        });

    }
    public static class bsAdapter extends BaseAdapter
    {
        Activity cntx;
        public bsAdapter(Activity context)
        {
            // TODO Auto-generated constructor stub
            this.cntx=context;
        }

        public int getCount()
        {
            // TODO Auto-generated method stub
            return array_sort.size();
        }

        public Object getItem(int position)
        {
            // TODO Auto-generated method stub
            return array_sort.get(position);
        }

        public long getItemId(int position)
        {
            // TODO Auto-generated method stub
            return array_sort.size();
        }

        public View getView(final int position, View convertView, ViewGroup parent)
        {
            View row=null;
            LayoutInflater inflater=cntx.getLayoutInflater();
            row=inflater.inflate(R.layout.list_item, null);
            TextView tv = (TextView) row.findViewById(R.id.title);
            TextView tv1 = (TextView) row.findViewById(R.id.email);

            ImageView im = (ImageView) row.findViewById(R.id.imageview);
            tv.setText(array_sort.get(position));
            tv1.setText(array_sort1.get(position));

            im.setImageBitmap(getRoundedShape(decodeFile(cntx, listview_images[position]),200));

            return row;
        }

        public static Bitmap decodeFile(Context context,int resId) {
            try {
// decode image size
                mcontext=context;
                BitmapFactory.Options o = new BitmapFactory.Options();
                o.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(mcontext.getResources(), resId, o);
// Find the correct scale value. It should be the power of 2.
                final int REQUIRED_SIZE = 200;
                int width_tmp = o.outWidth, height_tmp = o.outHeight;
                int scale = 1;
                while (true)
                {
                    if (width_tmp / 2 < REQUIRED_SIZE
                            || height_tmp / 2 < REQUIRED_SIZE)
                        break;
                    width_tmp /= 2;
                    height_tmp /= 2;
                    scale++;
                }
// decode with inSampleSize
                BitmapFactory.Options o2 = new BitmapFactory.Options();
                o2.inSampleSize = scale;
                return BitmapFactory.decodeResource(mcontext.getResources(), resId, o2);
            } catch (Exception e) {
            }
            return null;
        }
    }
    public static Bitmap getRoundedShape(Bitmap scaleBitmapImage,int width) {
        // TODO Auto-generated method stub
        int targetWidth = width;
        int targetHeight = width;
        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,
                targetHeight,Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addCircle(((float) targetWidth - 1) / 2,
                ((float) targetHeight - 1) / 2,
                (Math.min(((float) targetWidth),
                        ((float) targetHeight)) / 2),
                Path.Direction.CCW);
        canvas.clipPath(path);
        Bitmap sourceBitmap = scaleBitmapImage;
        canvas.drawBitmap(sourceBitmap,
                new Rect(0, 0, sourceBitmap.getWidth(),
                        sourceBitmap.getHeight()),
                new Rect(0, 0, targetWidth,
                        targetHeight), null);
        return targetBitmap;
    }






}