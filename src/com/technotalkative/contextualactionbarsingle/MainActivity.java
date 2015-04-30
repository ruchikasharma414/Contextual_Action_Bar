package com.technotalkative.contextualactionbarsingle;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends Activity {
 
    private ActionMode mActionMode;
    private CheckBox checkBox1;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        getActionBar().setTitle("CAB demo - Individual view");
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    mActionMode = MainActivity.this.startActionMode(new ActionBarCallBack());
                else
                    mActionMode.finish();
            }
        });
    }
 
    class ActionBarCallBack implements ActionMode.Callback {
 
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }
 
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.contextual_menu, menu);
            return true;
        }
 
        @Override
        public void onDestroyActionMode(ActionMode mode) {
        }
 
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            mode.setTitle("CheckBox is Checked");
            return false;
        }
 
    }
}