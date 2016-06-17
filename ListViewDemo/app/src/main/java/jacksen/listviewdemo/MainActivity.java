package jacksen.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;

    private static int MODE_ADAPTER = 0;
    private static final int MODE_ARRAY = 1;
    private static final int MODE_SIMPLE = 2;
    private static final int MODE_CURSOR = 3;
    private static final int MODE_CUSTOM = 4;


    private List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
    }

    /**
     * use ArrayAdapter
     */
    private void setArrayAdapter() {
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        list.add("item4");
        list.add("item5");
        list.add("item6");
        list.add("item7");
        list.add("item8");
        list.add("item9");
        list.add("item10");
        list.add("item11");
        list.add("item12");
        list.add("item13");
        list.add("item14");
        list.add("item15");
        arrayAdapter.addAll(list);
        listView.setAdapter(arrayAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add_item:
                switch (MODE_ADAPTER) {
                    case MODE_ARRAY:
                        list.add("item0");
                        arrayAdapter.notifyDataSetChanged();
                        break;
                    default:
                        break;
                }
                break;
            case R.id.action_delete_item:
                break;
            case R.id.action_array_adapter:
                setArrayAdapter();
                MODE_ADAPTER = MODE_ARRAY;
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
