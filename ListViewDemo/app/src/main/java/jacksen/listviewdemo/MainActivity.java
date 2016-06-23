package jacksen.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private List<Map<String, Object>> list2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
    }

    /**
     * 1. ArrayAdapter
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


    private void setSimpleCursorAdapter() {

    }


    private void setSimpleAdapter() {
        list2 = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("img", R.mipmap.songjiang);
        map.put("name", "songjiang");
        map.put("intro", "及时雨");
        list2.add(map);

        map = new HashMap<>();
        map.put("img", R.mipmap.likui);
        map.put("name", "李逵");
        map.put("intro", "黑旋风");
        list2.add(map);

        map = new HashMap<>();
        map.put("img", R.mipmap.wuyong);
        map.put("name", "吴用");
        map.put("intro", "智多星");
        list2.add(map);

        map = new HashMap<>();
        map.put("img", R.mipmap.linchong);
        map.put("name", "林冲");
        map.put("intro", "豹子头");
        list2.add(map);

        map = new HashMap<>();
        map.put("img", R.mipmap.luzhishen);
        map.put("name", "鲁智深");
        map.put("intro", "花和尚");
        list2.add(map);

        map = new HashMap<>();
        map.put("img", R.mipmap.lujunyi);
        map.put("name", "卢俊义");
        map.put("intro", "玉麒麟");
        list2.add(map);

        map = new HashMap<>();
        map.put("img", R.mipmap.gongsunsheng);
        map.put("name", "公孙胜");
        map.put("intro", "入云龙");
        list2.add(map);

        map = new HashMap<>();
        map.put("img", R.mipmap.lujunyi);
        map.put("name", "卢俊义");
        map.put("intro", "玉麒麟");
        list2.add(map);

        map = new HashMap<>();
        map.put("img", R.mipmap.gongsunsheng);
        map.put("name", "公孙胜");
        map.put("intro", "入云龙");
        list2.add(map);


        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list2, R.layout.item_linear, new String[]{"img", "name", "intro"},
                new int[]{R.id.item_image, R.id.item_name_tv, R.id.item_intro_tv});

        listView.setAdapter(simpleAdapter);

    }

    private void setCustomAdapter() {
        List<HeroBean> list3 = new ArrayList<>();
        list3.add(new HeroBean(R.mipmap.linchong, "林冲", "八十万禁军教头"));
        list3.add(new HeroBean(R.mipmap.songjiang, "宋江", "孝义黑三郎"));
        list3.add(new HeroBean(R.mipmap.likui, "李逵", "黑旋风李逵"));
        list3.add(new HeroBean(R.mipmap.gongsunsheng, "公孙胜", "入云龙"));
        list3.add(new HeroBean(R.mipmap.wuyong, "吴用", "智多星"));
        list3.add(new HeroBean(R.mipmap.luzhishen, "鲁智深", "花和尚"));

        HeroAdapter heroAdapter = new HeroAdapter(this, list3);
        listView.setAdapter(heroAdapter);
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
                if (MODE_ADAPTER != MODE_ARRAY) {
                    setArrayAdapter();
                    MODE_ADAPTER = MODE_ARRAY;
                }
                break;
            case R.id.action_simple_adapter:
                if (MODE_ADAPTER != MODE_SIMPLE) {
                    setSimpleAdapter();
                    MODE_ADAPTER = MODE_SIMPLE;
                }
                break;
            case R.id.action_custom_adapter:
                if (MODE_ADAPTER != MODE_CUSTOM){
                    setCustomAdapter();
                    MODE_ADAPTER = MODE_CUSTOM;
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
