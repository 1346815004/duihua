package com.example.duihua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duihua.model.UserMessage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private EditText et1;
    private RecyclerView rlv1;
    private LinearAdapter mUserWordMessageAdapter;
    private List<UserMessage> mUserWordMessageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        btn1 = findViewById(R.id.btn1);

        mUserWordMessageList = new ArrayList<>();
        mUserWordMessageAdapter = new LinearAdapter(mUserWordMessageList);
        rlv1 = findViewById(R.id.rlv1);
        rlv1.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rlv1.setAdapter(mUserWordMessageAdapter);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = et1.getText().toString();
                addSendMessage(s1);
                addSendMessage2("你说这些干你妈啊？");
            }

            private void addSendMessage2(String content) {
                    UserMessage userWordMessage = new UserMessage(content, UserMessage.TYPE_RECEIVE);
                    mUserWordMessageList.add(userWordMessage);
                    mUserWordMessageAdapter.notifyItemInserted(mUserWordMessageList.size() - 1);
            }

            private void addSendMessage(String content) {
                UserMessage userWordMessage = new UserMessage(content, UserMessage.TYPE_SEND);
                mUserWordMessageList.add(userWordMessage);

                // 表示在消息的末尾插入内容
                mUserWordMessageAdapter.notifyItemInserted(mUserWordMessageList.size() - 1);

            }
        });


    }
}