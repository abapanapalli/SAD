package com.example.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    // Data
    Context context;
    ArrayList<Playlist> playlistArrayList; // an array of playlist objects from which the
    // recycler view will be constructed from

    // Constructors

    /**
     * Constructor which build the adapter reading the playlist data
     * @param context the page which the RecyclerView is situated in
     * @param playlistArrayList the ArrayList of songs in the playlist to be displayed
     */

    public Adapter(Context context, ArrayList<Playlist> playlistArrayList) {
        this.context = context;
        this.playlistArrayList = playlistArrayList;
    }

    // Methods

    /**
     * Method which creates the view holder using the recycler_view_item layout as a model
     * @param parent The view group in which the recycler view is being constructed in
     * @param viewType The type of view which the recycler view will be modelled off
     * @return a MyViewHolder object which will contain a list view of all the songs in the
     * playlist
     */

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent,
                false);

        return new MyViewHolder(v);
    }

    /**
     * Method which populates the view holder with each of the objects in the playlist ArrayList
     * @param holder the MyViewHolder constructed in onCreateViewHolder method which will hold
     *               all the parameters in the RecyclerView
     * @param position the position of the element in the playlist ArrayList that will be
     *                 displayed in the RecyclerView
     */

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {

        Playlist playlist = playlistArrayList.get(position);
        holder.songName.setText(playlist.name);
        holder.songArtist.setText(playlist.artist);
        holder.titleImage.setImageResource(playlist.titleImage);

    }

    /**
     * A method which counts the number of objects in the ArrayList
     * @return size of ArrayList
     */

    @Override
    public int getItemCount() {
        return playlistArrayList.size();
    }

    /**
     * Constructor which sets the parameters for the ViewHolder
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // Data
        TextView songName;
        TextView songArtist;
        ImageView titleImage;

        /**
         * Method which constructs the view for one of the songs
         * @param itemView the view object
         */

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            songName = itemView.findViewById(R.id.song_name);
            songArtist = itemView.findViewById(R.id.song_artist);
            titleImage = itemView.findViewById(R.id.song_image);
        }
    }


}
