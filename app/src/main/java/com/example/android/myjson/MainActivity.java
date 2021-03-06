package com.example.android.myjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String newMessages;
    String check_Green="";
    int quantity_of_green_elements=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);

        String string =
                "{\n" +
                        "\"colors\": [\n" +
                        "{\n" +
                        "\"color\": \"black\",\n" +
                        "\"category\": \"hue\",\n" +
                        "\"type\": \"primary\",\n" +
                        "\"code\": {\n" +
                        "\"rgba\": [255,255,255,1],\n" +
                        "\"hex\": \"#000\"\n" +
                        "}\n" +
                        "},\n" +
                        "{\n" +
                        "\"color\": \"white\",\n" +
                        "\"category\": \"value\",\n" +
                        "\"code\": {\n" +
                        "\"rgba\": [0,0,0,1],\n" +
                        "\"hex\": \"#FFF\"\n" +
                        "}\n" +
                        "},\n" +
                        "{\n" +
                        "\"color\": \"red\",\n" +
                        "\"category\": \"hue\",\n" +
                        "\"type\": \"primary\",\n" +
                        "\"code\": {\n" +
                        "\"rgba\": [255,0,0,1],\n" +
                        "\"hex\": \"#FF0\"\n" +
                        "}\n" +
                        "},\n" +
                        "{\n" +
                        "\"color\": \"blue\",\n" +
                        "\"category\": \"hue\",\n" +
                        "\"type\": \"primary\",\n" +
                        "\"code\": {\n" +
                        "\"rgba\": [0,0,255,1],\n" +
                        "\"hex\": \"#00F\"\n" +
                        "}\n" +
                        "},\n" +
                        "{\n" +
                        "\"color\": \"yellow\",\n" +
                        "\"category\": \"hue\",\n" +
                        "\"type\": \"primary\",\n" +
                        "\"code\": {\n" +
                        "\"rgba\": [255,255,0,1],\n" +
                        "\"hex\": \"#FF0\"\n" +
                        "}\n" +
                        "},\n" +
                        "{\n" +
                        "\"color\": \"green\",\n" +
                        "\"category\": \"hue\",\n" +
                        "\"type\": \"secondary\",\n" +
                        "\"code\": {\n" +
                        "\"rgba\": [0,255,0,1],\n" +
                        "\"hex\": \"#0F0\"\n" +
                        "}\n" +
                        "}\n" +
                        "]\n" +
                        "}";

        try {

            JSONObject messages = (JSONObject) new JSONTokener(string).nextValue();
            JSONArray colors = (JSONArray) messages.getJSONArray("colors");
            for (int i=0; i<colors.length(); i++) {
                JSONObject color = (JSONObject) colors.get(i);
                JSONObject code = (JSONObject) color.get("code");
                JSONArray rgba = (JSONArray) code.get("rgba");
                if((int)rgba.get(1)== 255) {
                    quantity_of_green_elements++;
                    check_Green+= color.getString("color")+ " ";
                }
            }
            JSONObject message = new JSONObject();
            JSONObject new_code = new JSONObject();
            message.put("color","orange");
            message.put("category","hue");
            int[] new_rgba = new int[4];
            new_rgba[0] = 255;
            new_rgba[1] = 165;
            new_rgba[2] = 0;
            new_rgba[3] = 1;
            new_code.put("rgba", Arrays.toString(new_rgba));
            new_code.put("hex","#FA0");
            message.put("code",new_code);
            messages.put("colors",message);
            newMessages = messages.toString(2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void list(View view) {
        textView.setText(check_Green);
    }

    public void modify(View view) {
        textView.setText(newMessages);

    }

    public void count(View view) {
        textView.setText(Integer.toString(quantity_of_green_elements));
    }
}