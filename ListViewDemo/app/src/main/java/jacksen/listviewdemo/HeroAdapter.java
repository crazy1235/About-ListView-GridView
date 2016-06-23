package jacksen.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 2016/6/16.
 */

public class HeroAdapter extends BaseAdapter {

    private List<HeroBean> list;

    private LayoutInflater layoutInflater;

    public HeroAdapter(Context context, List<HeroBean> list) {
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = layoutInflater.inflate(R.layout.item_linear, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.item_image);
            viewHolder.nameTV = (TextView) convertView.findViewById(R.id.item_name_tv);
            viewHolder.introTv = (TextView) convertView.findViewById(R.id.item_intro_tv);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imageView.setImageResource(list.get(position).getImgRes());
        viewHolder.nameTV.setText(list.get(position).getName());
        viewHolder.introTv.setText(list.get(position).getIntroduce());

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView nameTV;
        TextView introTv;
    }
}
