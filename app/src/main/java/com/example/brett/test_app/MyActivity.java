package com.example.brett.test_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MyActivity extends Activity {

    private ArrayList<String> adventures;
    private Boolean flag;
    {
        flag = false;
        adventures = resetAdventures();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public ArrayList<String> resetAdventures()
    {
        
        // build the temp list
        ArrayList<String> temp = new ArrayList<String>();
        temp.add("Bob hits the road excited for his new adventure. Sadly Bob is a very literal person. He begins hitting the road first with his hands, and then with his skull. You killed Bob.");
        temp.add("Bob, not feeling quite up for an adventure, begrudgingly begins walking down the road. He makes Eye contact with a punk kid pokemon trainer. He uses Charizzard. Your adventure killed Bob.");
        temp.add("Bob loves your idea of going on an adventure. He quickly runs out into the woods. where he gets eatten by the same wolf that killed his grandmother. Your adventure killed Bob.");
        temp.add("Bob says \"I used to be an adventure like you but then he took an arrow to the knee.\" The dragonborn bursts through the window and shouts \"Fus Ra Da\". Your adventure killed Bob.");
        temp.add("Bob likes adventures. He decides to begin packing. While packing hes gets attacked by a decepticon. You killed Bob.");
        temp.add("Bob would rather die than go on an adventure with you. He devours a cyanide pill. With his last breath Bob curses you. You killed Bob.");
        temp.add("Bob\'s wife refuses to let him go on an adventure with you. She makes Bob take out the trash. Bob gets hit by a truck. What an adventure! Bob\'s wife killed bob.");
        temp.add("Bob wants to go on an adventure with you. You set out on and adventure to the mountains. as you approach a mountain cave a dragon flys out of the cave burning Bob to a crisp. Bob is dead.");
        temp.add("Bob likes adventures. You go to a rock concert, meet Neil Patrick Harris, hit the night life and return home. Bob thanks you for being such a great friend.");


        // assign the temp array list into the adventures ArrayList
        return temp;
    }


    public void changeText(View v)
    {
        if (this.flag == false)
            this.chooseAdventure(v);
        else
            this.resetText(v);
    }

    public void resetText(View v)
    {
        TextView text = (TextView) findViewById(R.id.textView1);
        Button button1 = (Button) findViewById(R.id.button1);

        text.setText(R.string.hello_friend);
        button1.setText(R.string.send_bob_on_adventure);
        flag = false;
    }

    public void chooseAdventure(View v)
    {
        int i = 0;
        // reset adventure array if all values have been used.
        if (this.adventures.size() == 0)
        {
            this.adventures= resetAdventures();
        }

        TextView text = (TextView) findViewById(R.id.textView1);
        Button button1 = (Button) findViewById(R.id.button1);

        Random rand = new Random();
        if(this.adventures.size() > 1)
        {
            i = rand.nextInt(this.adventures.size());
        }

        // display the adventure (single value in the collection)
        text.setText(this.adventures.get(i));
        button1.setText(R.string.try_again);

        // remove item from the collection
        this.adventures.remove(i);

        // set flag for changeText() logic
        this.flag = true;
    }

}
