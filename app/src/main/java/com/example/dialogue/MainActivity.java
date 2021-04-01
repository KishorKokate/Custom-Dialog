package com.example.dialogue;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.yarolegovich.lovelydialog.LovelyChoiceDialog;
import com.yarolegovich.lovelydialog.LovelyCustomDialog;
import com.yarolegovich.lovelydialog.LovelyInfoDialog;
import com.yarolegovich.lovelydialog.LovelyProgressDialog;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;
import com.yarolegovich.lovelydialog.LovelyTextInputDialog;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @SuppressLint("ResourceType")
    public void StandarDialog(View view){
        new LovelyStandardDialog(MainActivity.this, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.bg)
                .setButtonsColorRes(R.color.purple_500)
                .setIcon(R.drawable.rate)
                .setIconTintColor(R.color.white)
                .setTitle("Rate Us")
                .setMessage("This is only standard dialog message that willm shown below title and that's it.")
                .setPositiveButton(android.R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "positive clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .show();
    }

    @SuppressLint("ResourceType")
    public void InfoDialog(View view){
        new LovelyInfoDialog(MainActivity.this)
                .setTopColorRes(R.color.bg)
                .setIcon(R.drawable.info)
                //This will add Don't show again checkbox to the dialog. You can pass any ID as argument
                .setNotShowAgainOptionEnabled(0)
                .setNotShowAgainOptionChecked(true)
                .setTitle("Info Dialog")
                .setMessage("Dialog for displaying information to the user, content is scrollable. There is an option to show Don\'t show again checkbox. If checked - dialog won\'t be called next time.")
                .show();
    }

    @SuppressLint("ResourceType")
    public void TextInputDialog(View view){

        new LovelyTextInputDialog(MainActivity.this)
                .setTopColorRes(R.color.bg)
                .setTitle("Text Input Dialog")
                .setMessage("Dialog with EditText and Confirm button. You can set TextFilter object to specify acceptable input.")
                .setIcon(R.drawable.input)
                .setInputFilter(R.string.text_input_error_message, new LovelyTextInputDialog.TextFilter() {
                    @Override
                    public boolean check(String text) {
                        return text.matches("\\w+");
                    }
                })
                .setConfirmButton(android.R.string.ok, new LovelyTextInputDialog.OnTextInputConfirmListener() {
                    @Override
                    public void onTextInputConfirmed(String text) {
                        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
    @SuppressLint("ResourceType")
    public void ChoiceDialog(View view){
        String[] items = getResources().getStringArray(R.array.food);
        new LovelyChoiceDialog(MainActivity.this)
                .setTopColorRes(R.color.bg)
                .setTitle("Choice Dialog")
                .setIcon(R.drawable.choice)
                .setItemsMultiChoice(items, new LovelyChoiceDialog.OnItemsSelectedListener<String>() {
                    @SuppressLint("StringFormatInvalid")
                    @Override
                    public void onItemsSelected(List<Integer> positions, List<String> items) {
                        Toast.makeText(MainActivity.this,
                                getString(R.string.your_order, TextUtils.join("\n", items)),
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                })
                .setConfirmButtonText("confirm")
                .show();

    }

    public void ProgressDialog(View view){
        new LovelyProgressDialog(MainActivity.this)
                .setIcon(R.drawable.prpogress)
                .setIconTintColor(R.color.white)
                .setTitle("Please Wait....")
                .setTopColorRes(R.color.black)
                .show();
    }
    public void CustomDialog(View view){
        new LovelyCustomDialog(MainActivity.this)
                .setTopColorRes(R.color.bg)
                .setTitle("Custom Dialog")
                .setMessage("Here you can pass your own view to be displayed. Title, message, color header and icon will still be available for use. You can provide configurators, click listeners and instance state save handlers.")
                .setIcon(R.drawable.custom)
                .show();
    }
}