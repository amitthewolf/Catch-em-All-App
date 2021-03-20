package com.example.mohsin.customlistview;

import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Debug;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button SwitchButton;
    Button SwapPokemon;
    Button BattleButton;
    Button LevelPokemon;
    Button KillPokemon;
    Button ChooseOpponent;
    Button ChoosePokemon;
    Button BackButton;
    TextView MyBonus;
    TextView EnemyBonus;
    ImageView BattlingPokemon;
    ImageView EnemyPokemon;
    int ChosenPokemonID;
    int enemyID = -1;
    MediaPlayer EveSound;

    String mTitle[] = {"001 : Bulbasaur","002 : Ivysaur","003 : Venusaur","004 : Charmander", "005 : Charmeleon", "006 : Charizard","007 : Squirtle", "008 : Wartortle", "009 : Blastoise", "010 : Caterpie", "011 : Metapod", "012 : Butterfree", "013 : Weedle", "014 : Kakuna", "015 : Beedrill", "016 : Pidgey", "017 : Pidgeotto", "018 : Pidgeot", "019 : Rattata", "020 : Raticate", "021 : Spearow", "022 : Fearow", "023 : Ekans", "024 : Arbok", "025 : Pikachu", "026 : Raichu", "027 : Sandshrew", "028 : Sandslash", "029 : Nidoran (Female)", "030 : Nidorina", "031 : Nidoqueen", "032 : Nidoran (Male)", "033 : Nidorino", "034 : Nidoking", "035 : Clefairy", "036 : Clefable", "037 : Vulpix", "038 : Ninetales", "039 : Jigglypuff", "040 : Wigglytuff", "041 : Zubat", "042 : Golbat", "043 : Oddish", "044 : Gloom", "045 : Vileplume", "046 : Paras", "047 : Parasect", "048 : Venonat", "049 : Venomoth", "050 : Diglett", "051 : Dugtrio", "052 : Meowth", "053 : Persian", "054 : Psyduck", "055 : Golduck", "056 : Mankey", "057 : Primeape", "058 : Growlithe", "059 : Arcanine", "060 : Poliwag", "061 : Poliwhirl", "062 : Poliwrath", "063 : Abra", "064 : Kadabra", "065 : Alakazam", "066 : Machop", "067 : Machoke", "068 : Machamp", "069 : Bellsprout", "070 : Weepinbell", "071 : Victreebel", "072 : Tentacool", "073 : Tentacruel", "074 : Geodude", "075 : Graveler", "076 : Golem", "077 : Ponyta", "078 : Rapidash", "079 : Slowpoke", "080 : Slowbro", "081 : Magnemite", "082 : Magneton", "083 : Farfetch'd", "084 : Doduo", "085 : Dodrio", "086 : Seel", "087 : Dewgong", "088 : Grimer", "089 : Muk", "090 : Shellder", "091 : Cloyster", "092 : Gastly", "093 : Haunter", "094 : Gengar", "095 : Onix", "096 : Drowzee", "097 : Hypno", "098 : Krabby", "099 : Kingler", "100 : Voltorb", "101 : Electrode", "102 : Exeggcute", "103 : Exeggutor", "104 : Cubone", "105 : Marowak", "106 : Hitmonlee", "107 : Hitmonchan", "108 : Lickitung", "109 : Koffing", "110 : Weezing", "111 : Rhyhorn", "112 : Rhydon", "113 : Chansey", "114 : Tangela", "115 : Kangaskhan", "116 : Horsea", "117 : Seadra", "118 : Goldeen", "119 : Seaking", "120 : Staryu", "121 : Starmie", "122 : Mr. Mime", "123 : Scyther", "124 : Jynx", "125 : Electabuzz", "126 : Magmar", "127 : Pinsir", "128 : Tauros", "129 : Magikarp", "130 : Gyarados", "131 : Lapras", "132 : Ditto", "133 : Eevee", "134 : Vaporeon", "135 : Jolteon", "136 : Flareon", "137 : Porygon", "138 : Omanyte", "139 : Omastar", "140 : Kabuto", "141 : Kabutops", "142 : Aerodactyl", "143 : Snorlax", "144 : Articuno", "145 : Zapdos", "146 : Moltres", "147 : Dratini", "148 : Dragonair", "149 : Dragonite", "150 : Mewtwo"};
    String mDescription[] = {"Power: 4, Evolves into:2", "Power: 7, Evolves into:3", "Power: 8", "Power: 4, Evolves into:5", "Power: 7, Evolves into:6", "Power: 8", "Power: 4, Evolves into:8", "Power: 7, Evolves into:9", "Power: 8", "Power: 1, Evolves into:11", "Power: 3, Evolves into:12", "Power: 5", "Power: 2, Evolves into:14", "Power: 3, Evolves into:15", "Power: 5", "Power: 2, Evolves into:17", "Power: 4, Evolves into:18", "Power: 6", "Power: 2, Evolves into:20", "Power: 6", "Power: 3, Evolves into:22", "Power: 5", "Power: 3, Evolves into:24", "Power: 5", "Power: 3, Evolves into:26", "Power: 6", "Power: 2, Evolves into:28", "Power: 5", "Power: 2, Evolves into:30", "Power: 5, Evolves into:31", "Power: 6", "Power: 3, Evolves into:33", "Power: 5, Evolves into:34", "Power: 6", "Power: 3, Evolves into:36", "Power: 4", "Power: 1, Evolves into:38", "Power: 5", "Power: 2, Evolves into:40", "Power: 4", "Power: 3, Evolves into:42", "Power: 4", "Power: 2, Evolves into:44", "Power: 5, Evolves into:45", "Power: 5", "Power: 1, Evolves into:47", "Power: 5", "Power: 2, Evolves into:49", "Power: 5", "Power: 2, Evolves into:51", "Power: 4", "Power: 3, Evolves into:53", "Power: 6", "Power: 2, Evolves into:55", "Power: 5", "Power: 5, Evolves into:57", "Power: 7", "Power: 4, Evolves into:59", "Power: 7", "Power: 2, Evolves into:61", "Power: 4, Evolves into:62", "Power: 7", "Power: 2, Evolves into:64", "Power: 4, Evolves into:65", "Power: 7", "Power: 5, Evolves into:67", "Power: 7, Evolves into:68", "Power: 8", "Power: 1, Evolves into:70", "Power: 3, Evolves into:71", "Power: 6", "Power: 1, Evolves into:73", "Power: 4", "Power: 1, Evolves into:75", "Power: 4, Evolves into:76", "Power: 6", "Power: 5, Evolves into:78", "Power: 7", "Power: 2, Evolves into:80", "Power: 3", "Power: 2, Evolves into:82", "Power: 4", "Power: 5", "Power: 3, Evolves into:85", "Power: 5", "Power: 5, Evolves into:87", "Power: 7", "Power: 3, Evolves into:89", "Power: 4", "Power: 2, Evolves into:91", "Power: 5", "Power: 2, Evolves into:93", "Power: 4, Evolves into:94", "Power: 7", "Power: 7", "Power: 4, Evolves into:97", "Power: 6", "Power: 3, Evolves into:99", "Power: 5", "Power: 3, Evolves into:101", "Power: 5", "Power: 1, Evolves into:103", "Power: 7", "Power: 3, Evolves into:105", "Power: 6", "Power: 7", "Power: 7", "Power: 4", "Power: 4, Evolves into:110", "Power: 5", "Power: 6, Evolves into:112", "Power: 8", "Power: 7", "Power: 3", "Power: 1", "Power: 1, Evolves into:117", "Power: 5", "Power: 2, Evolves into:119", "Power: 4", "Power: 2, Evolves into:121", "Power: 4", "Power: 6", "Power: 7", "Power: 5", "Power: 8", "Power: 7", "Power: 5", "Power: 8", "Power: 1, Evolves into:130", "Power: 8", "Power: 7", "Power: 5", "Power: 3, Evolves into:134", "Power: 6", "Power: 6", "Power: 6", "Power: 5", "Evolves into:139", "Power: 7", "Power: 5, Evolves into:141", "Power: 7", "Power: 7", "Power: 7", "Power: 9", "Power: 9", "Power: 9", "Power: 5, Evolves into:148", "Power: 6, Evolves into:149", "Power: 7", "Power: 9"};
    int images[] = { R.drawable.bulbasaur, R.drawable.ivysaur, R.drawable.venusaur, R.drawable.charmander, R.drawable.charmeleon, R.drawable.charizard, R.drawable.squirtle, R.drawable.wartortle, R.drawable.blastoise, R.drawable.caterpie, R.drawable.metapod, R.drawable.butterfree, R.drawable.weedle, R.drawable.kakuna, R.drawable.beedrill, R.drawable.pidgey, R.drawable.pidgeotto, R.drawable.pidgeot, R.drawable.rattata, R.drawable.raticate, R.drawable.spearow, R.drawable.fearow, R.drawable.ekans, R.drawable.arbok, R.drawable.pikachu, R.drawable.raichu, R.drawable.sandshrew, R.drawable.sandslash, R.drawable.nidoranf, R.drawable.nidorina, R.drawable.nidoqueen, R.drawable.nidoranm, R.drawable.nidorino, R.drawable.nidoking, R.drawable.clefairy, R.drawable.clefable,R.drawable.vulpix,R.drawable.ninetales, R.drawable.jigglypuff, R.drawable.wigglytuff, R.drawable.zubat, R.drawable.golbat, R.drawable.oddish, R.drawable.gloom, R.drawable.vileplume, R.drawable.paras, R.drawable.parasect, R.drawable.venonat, R.drawable.venomoth, R.drawable.diglett, R.drawable.dugtrio, R.drawable.meowth, R.drawable.persian, R.drawable.psyduck, R.drawable.golduck, R.drawable.mankey, R.drawable.primeape, R.drawable.growlithe, R.drawable.arcanine, R.drawable.poliwag, R.drawable.poliwhirl, R.drawable.poliwrath, R.drawable.abra, R.drawable.kadabra, R.drawable.alakazam, R.drawable.machop, R.drawable.machoke, R.drawable.machamp, R.drawable.bellsprout, R.drawable.weepinbell, R.drawable.victreebel, R.drawable.tentacool, R.drawable.tentacruel, R.drawable.geodude, R.drawable.graveler, R.drawable.golem, R.drawable.ponyta, R.drawable.rapidash, R.drawable.slowpoke, R.drawable.slowbro, R.drawable.magnemite, R.drawable.magneton, R.drawable.farfetch, R.drawable.doduo, R.drawable.dodrio, R.drawable.seel, R.drawable.dewgong, R.drawable.grimer, R.drawable.muk, R.drawable.shellder, R.drawable.cloyster, R.drawable.gastly, R.drawable.haunter, R.drawable.gengar, R.drawable.onix, R.drawable.drowzee, R.drawable.hypno, R.drawable.krabby, R.drawable.kingler, R.drawable.voltorb, R.drawable.electrode, R.drawable.exeggcute, R.drawable.exeggutor, R.drawable.cubone, R.drawable.marowak, R.drawable.hitmonlee, R.drawable.hitmonchan, R.drawable.lickitung, R.drawable.koffing, R.drawable.weezing, R.drawable.rhyhorn, R.drawable.rhydon, R.drawable.chansey, R.drawable.tangela, R.drawable.kangaskhan, R.drawable.horsea, R.drawable.seadra, R.drawable.goldeen, R.drawable.seaking, R.drawable.staryu, R.drawable.starmie, R.drawable.mr, R.drawable.scyther, R.drawable.jynx, R.drawable.electabuzz, R.drawable.magmar, R.drawable.pinsir, R.drawable.tauros, R.drawable.magikarp,R.drawable.gyarados,R.drawable.lapras, R.drawable.ditto, R.drawable.eevee, R.drawable.vaporeon, R.drawable.jolteon, R.drawable.flareon, R.drawable.porygon, R.drawable.omanyte, R.drawable.omastar, R.drawable.kabuto, R.drawable.kabutops, R.drawable.aerodactyl, R.drawable.snorlax, R.drawable.articuno, R.drawable.zapdos, R.drawable.moltres, R.drawable.dratini, R.drawable.dragonair, R.drawable.dragonite, R.drawable.mewtwo};
    int shinyimages[] = { R.drawable.shinybulbasaur, R.drawable.shinyivysaur, R.drawable.shinyvenusaur, R.drawable.shinycharmander, R.drawable.shinycharmeleon, R.drawable.shinycharizard, R.drawable.shinysquirtle, R.drawable.shinywartortle, R.drawable.shinyblastoise, R.drawable.shinycaterpie, R.drawable.shinymetapod, R.drawable.shinybutterfree, R.drawable.shinyweedle, R.drawable.shinykakuna, R.drawable.shinybeedrill, R.drawable.shinypidgey, R.drawable.shinypidgeotto, R.drawable.shinypidgeot, R.drawable.shinyrattata, R.drawable.shinyraticate, R.drawable.shinyspearow, R.drawable.shinyfearow, R.drawable.shinyekans, R.drawable.shinyarbok, R.drawable.shinypikachu, R.drawable.shinyraichu, R.drawable.shinysandshrew, R.drawable.shinysandslash, R.drawable.shinynidoranf, R.drawable.shinynidorina, R.drawable.shinynidoqueen, R.drawable.shinynidoranm, R.drawable.shinynidorino, R.drawable.shinynidoking, R.drawable.shinyclefairy, R.drawable.shinyclefable, R.drawable.shinyvulpix, R.drawable.shinyninetales, R.drawable.shinyjigglypuff, R.drawable.shinywigglytuff, R.drawable.shinyzubat, R.drawable.shinygolbat, R.drawable.shinyoddish, R.drawable.shinygloom, R.drawable.shinyvileplume, R.drawable.shinyparas, R.drawable.shinyparasect, R.drawable.shinyvenonat, R.drawable.shinyvenomoth, R.drawable.shinydiglett, R.drawable.shinydugtrio, R.drawable.shinymeowth, R.drawable.shinypersian, R.drawable.shinypsyduck, R.drawable.shinygolduck, R.drawable.shinymankey, R.drawable.shinyprimeape, R.drawable.shinygrowlithe, R.drawable.shinyarcanine, R.drawable.shinypoliwag, R.drawable.shinypoliwhirl, R.drawable.shinypoliwrath, R.drawable.shinyabra, R.drawable.shinykadabra, R.drawable.shinyalakazam, R.drawable.shinymachop, R.drawable.shinymachoke, R.drawable.shinymachamp, R.drawable.shinybellsprout, R.drawable.shinyweepinbell, R.drawable.shinyvictreebel, R.drawable.shinytentacool, R.drawable.shinytentacruel, R.drawable.shinygeodude, R.drawable.shinygraveler, R.drawable.shinygolem, R.drawable.shinyponyta, R.drawable.shinyrapidash, R.drawable.shinyslowpoke, R.drawable.shinyslowbro, R.drawable.shinymagnemite, R.drawable.shinymagneton, R.drawable.shinyfarfetchd, R.drawable.shinydoduo, R.drawable.shinydodrio, R.drawable.shinyseel, R.drawable.shinydewgong, R.drawable.shinygrimer, R.drawable.shinymuk, R.drawable.shinyshellder, R.drawable.shinycloyster, R.drawable.shinygastly, R.drawable.shinyhaunter, R.drawable.shinygengar, R.drawable.shinyonix, R.drawable.shinydrowzee, R.drawable.shinyhypno, R.drawable.shinykrabby, R.drawable.shinykingler, R.drawable.shinyvoltorb, R.drawable.shinyelectrode, R.drawable.shinyexeggcute, R.drawable.shinyexeggutor, R.drawable.shinycubone, R.drawable.shinymarowak, R.drawable.shinyhitmonlee, R.drawable.shinyhitmonchan, R.drawable.shinylickitung, R.drawable.shinykoffing, R.drawable.shinyweezing, R.drawable.shinyrhyhorn, R.drawable.shinyrhydon, R.drawable.shinychansey, R.drawable.shinytangela, R.drawable.shinykangaskhan, R.drawable.shinyhorsea, R.drawable.shinyseadra, R.drawable.shinygoldeen, R.drawable.shinyseaking, R.drawable.shinystaryu, R.drawable.shinystarmie, R.drawable.shinymr, R.drawable.shinyscyther, R.drawable.shinyjynx, R.drawable.shinyelectabuzz, R.drawable.shinymagmar, R.drawable.shinypinsir, R.drawable.shinytauros, R.drawable.shinymagikarp, R.drawable.shinygyarados, R.drawable.shinylapras, R.drawable.shinyditto, R.drawable.shinyeevee, R.drawable.shinyvaporeon, R.drawable.shinyjolteon, R.drawable.shinyflareon, R.drawable.shinyporygon, R.drawable.shinyomanyte, R.drawable.shinyomastar, R.drawable.shinykabuto, R.drawable.shinykabutops, R.drawable.shinyaerodactyl, R.drawable.shinysnorlax, R.drawable.shinyarticuno, R.drawable.shinyzapdos, R.drawable.shinymoltres, R.drawable.shinydratini, R.drawable.shinydragonair, R.drawable.shinydragonite, R.drawable.shinymewtwo};
    String Types[] = {"Grass,Poison","Grass,Poison","Grass,Poison","Fire","Fire","Fire,Flying","Water","Water","Water","Bug","Bug","Bug,Flying","Bug,Poison","Bug,Poison","Bug,Poison","Normal,Flying","Normal,Flying","Normal,Flying","Normal","Normal","Normal,Flying","Normal,Flying","Poison","Poison","Electric","Electric","Ground","Ground","Poison","Poison","Poison,Ground","Poison","Poison","Poison,Ground","Normal","Normal","Fire","Fire","Normal","Normal","Poison,Flying","Poison,Flying","Grass,Poison","Grass,Poison","Grass,Poison","Bug,Grass","Bug,Grass","Bug,Poison","Bug,Poison","Ground","Ground","Normal","Normal","Water","Water","Fighting","Fighting","Fire","Fire","Water","Water","Water,Fighting","Psychic","Psychic","Psychic","Fighting","Fighting","Fighting","Grass,Poison","Grass,Poison","Grass,Poison","Water,Poison","Water,Poison","Rock,Ground","Rock,Ground","Rock,Ground","Fire","Fire","Water,Psychic","Water,Psychic","Electric","Electric","Normal,Flying","Normal,Flying","Normal,Flying","Water","Water,Ice","Poison","Poison","Water","Water,Ice","Ghost,Poison","Ghost,Poison","Ghost,Poison","Rock,Ground","Psychic","Psychic","Water","Water","Electric","Electric","Grass,Psychic","Grass,Psychic","Ground","Ground","Fighting","Fighting","Normal","Poison","Poison","Ground,Rock","Ground,Rock","Normal","Grass","Normal","Water","Water","Water","Water","Water","Water,Psychic","Psychic","Bug,Flying","Ice,Psychic","Electric","Fire","Bug","Normal","Water","Water,Flying","Water,Ice","Normal","Normal","Water","Electric","Fire","Normal","Rock,Water","Rock,Water","Rock,Water","Rock,Water","Rock,Flying","Normal","Ice,Flying","Electric,Flying","Fire,Flying","Dragon","Dragon","Dragon,Flying","Psychic","Psychic"};
    String Weaknesses[] = {"Fire,Ice,Flying,Psychic","Fire,Ice,Flying,Psychic","Fire,Ice,Flying,Psychic","Water,Ground,Rock","Water,Ground,Rock","Water,Electric,Rock","Electric,Grass","Electric,Grass","Electric,Grass","Fire,Flying,Rock","Fire,Flying,Rock","Fire,Electric,Ice,Flying,Rock","Fire,Flying,Psychic,Rock","Fire,Flying,Psychic,Rock","Fire,Flying,Psychic,Rock","Electric,Rock","Electric,Rock","Electric,Rock","Fighting","Fighting","Electric,Rock","Electric,Rock","Ground,Psychic","Ground,Psychic","Ground","Ground","Water,Grass,Ice","Water,Grass,Ice","Ground,Psychic","Ground,Psychic","Water,Ice,Ground,Psychic","Ground,Psychic","Ground,Psychic","Water,Ice,Ground,Psychic","Fighting","Fighting","Water,Ground,Rock","Water,Ground,Rock","Fighting","Fighting","Electric,Ice,Psychic,Rock","Electric,Ice,Psychic,Rock","Fire,Ice,Flying,Psychic","Fire,Ice,Flying,Psychic","Fire,Ice,Flying,Psychic","Fire,Ice,Poison,Flying,Bug,Rock","Fire,Ice,Poison,Flying,Bug,Rock","Fire,Flying,Psychic,Rock","Fire,Flying,Psychic,Rock","Water,Grass,Ice","Water,Grass,Ice","Fighting","Fighting","Electric,Grass","Electric,Grass","Flying,Psychic,Fairy","Flying,Psychic,Fairy","Water,Ground,Rock","Water,Ground,Rock","Electric,Grass","Electric,Grass","Electric,Grass,Flying,Psychic,Fairy","Bug,Ghost,Dark","Bug,Ghost,Dark","Bug,Ghost,Dark","Flying,Psychic,Fairy","Flying,Psychic,Fairy","Flying,Psychic,Fairy","Fire,Ice,Flying,Psychic","Fire,Ice,Flying,Psychic","Fire,Ice,Flying,Psychic","Electric,Ground,Psychic","Electric,Ground,Psychic","Water,Grass,Ice,Fighting,Ground,Steel","Water,Grass,Ice,Fighting,Ground,Steel","Water,Grass,Ice,Fighting,Ground,Steel","Water,Ground,Rock","Water,Ground,Rock","Electric,Grass,Bug,Ghost,Dark","Electric,Grass,Bug,Ghost,Dark","Fire,Water,Ground","Fire,Water,Ground","Electric,Rock","Electric,Rock","Electric,Rock","Electric,Grass","Electric,Grass,Fighting,Rock","Ground,Psychic","Ground,Psychic","Electric,Grass","Electric,Grass,Fighting,Rock","Ground,Psychic,Ghost,Dark","Ground,Psychic,Ghost,Dark","Ground,Psychic,Ghost,Dark","Water,Grass,Ice,Fighting,Ground,Steel","Bug,Ghost,Dark","Bug,Ghost,Dark","Electric,Grass","Electric,Grass","Ground","Ground","Fire,Ice,Poison,Flying,Bug,Ghost,Dark","Fire,Ice,Poison,Flying,Bug,Ghost,Dark","Water,Grass,Ice","Water,Grass,Ice","Flying,Psychic,Fairy","Flying,Psychic,Fairy","Fighting","Ground,Psychic","Ground,Psychic","Water,Grass,Ice,Fighting,Ground,Steel","Water,Grass,Ice,Fighting,Ground,Steel","Fighting","Fire,Ice,Poison,Flying,Bug","Fighting","Electric,Grass","Electric,Grass","Electric,Grass","Electric,Grass","Electric,Grass","Electric,Grass,Bug,Ghost,Dark","Bug,Ghost,Dark","Fire,Electric,Ice,Flying,Rock","Fire,Bug,Rock,Ghost,Dark,Steel","Ground","Water,Ground,Rock","Fire,Flying,Rock","Fighting","Electric,Grass","Electric,Rock","Electric,Grass,Fighting,Rock","Fighting","Fighting","Electric,Grass","Ground","Water,Ground,Rock","Fighting","Electric,Grass,Fighting,Ground","Electric,Grass,Fighting,Ground","Electric,Grass,Fighting,Ground","Electric,Grass,Fighting,Ground","Water,Electric,Ice,Rock,Steel","Fighting","Fire,Electric,Rock,Steel","Ice,Rock","Water,Electric,Rock","Ice,Dragon,Fairy","Ice,Dragon,Fairy","Ice,Rock,Dragon,Fairy","Bug,Ghost,Dark","Bug,Ghost,Dark"};
    String myPokemonTitles[];
    int myPokemonimages[];
    String MyPokemonDescs[];
    PokemonTracker MyPokemon[];
    String MyPokemonPowers[];
    int PokeCounter = 0;
    int Swap1;
    int Swap2;
    boolean BigList = true;
    boolean InBattle = false;
    MyAdapter adapter;
    MyPokemonAdapter myPokemonAdapter;
    TrackerAdapter ExpAdapter;
//    int images[] = {};
    // so our images and other things are set in array

    // now paste some images in drawable
    @Override
    public void onBackPressed() {
        SwitchView();
    }


    private void SwitchView() {
        if(BigList)
        {
            setContentView(R.layout.buttonlistush);
            listView = findViewById(R.id.leftListView);
            listView.setAdapter(myPokemonAdapter);
            SwitchButton = findViewById(R.id.SwitchButton2);
            BattleButton = findViewById(R.id.RemovePokemon);
            SwapPokemon = findViewById(R.id.PositionPokemon);
            LevelPokemon = findViewById(R.id.LevelPokemon);
            KillPokemon = findViewById(R.id.KillPokemon);
            SwitchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SwitchView();
                }
            });
            SwapPokemon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SetClickToSwap();
                }
            });
            BattleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SetClickToBattle();
                }
            });
            LevelPokemon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SetClickToLevel();
                }
            });
            KillPokemon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SetClickToKill();
                }
            });
            BigList=false;
        }
        else {
            setContentView(R.layout.activity_main);
            listView = findViewById(R.id.listView);
            listView.setAdapter(adapter);
            SwitchButton = findViewById(R.id.SwitchButton);
            SetClickToAdd();
            SwitchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SwitchView();
                }
            });
            BigList=true;
        }

    }

    private void BattleScene(int chosenID,int enemyID) {
        ChosenPokemonID = chosenID;
        if(!InBattle)
        {
            setContentView(R.layout.battlescene);
            MyBonus = findViewById(R.id.DmgBonus1);
            EnemyBonus = findViewById(R.id.DmgBonus2);
            ChooseOpponent = findViewById(R.id.SwitchOpponnent);
            ChoosePokemon = findViewById(R.id.SwitchMyPokemon);
            BackButton = findViewById(R.id.BacktoMyPokemon);
            BattlingPokemon = findViewById(R.id.battlingpokemon);
            EnemyPokemon = findViewById(R.id.EnemyPokemon);
            BattlingPokemon.setImageResource(images[chosenID]);
            if (enemyID != -1)
            {
               EnemyPokemon.setImageResource(images[enemyID]);
               if(CheckMyBonus(chosenID,enemyID))
               {
                   MyBonus.setText("+2");
               }
               if(CheckEnemyBonus(chosenID,enemyID))
               {
                   EnemyBonus.setText("+2");
               }
            }
            BackButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BigList = true;
                    SwitchView();
                }
            });
            ChooseOpponent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ChooseOpponent();
                }
            });
        }
    }

    private void ChooseOpponent(){
            setContentView(R.layout.activity_main);
            listView = findViewById(R.id.listView);
            listView.setAdapter(adapter);
            SwitchButton = findViewById(R.id.SwitchButton);
            SetClickToBattleEnemy();
            SwitchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BattleScene(ChosenPokemonID,-1);
                }
            });
            BigList=true;
    }

    private boolean CheckEnemyBonus(int MyID, int enemyID) {
        String EnemyType[] = Types[enemyID].split(",");
        String MyWeakness[] = Weaknesses[MyID].split(",");

        for (String Type : EnemyType){
            for( String Weakness : MyWeakness)
            {
                if(Type.equals(Weakness))
                    return true;
            }
        }
        return false;
    }


    private boolean CheckMyBonus(int MyID, int enemyID) {
        String MyType[] = Types[MyID].split(",");
        String  EnemyWeakness[] = Weaknesses[enemyID].split(",");
        for (String Type : MyType){
            for( String Weakness : EnemyWeakness)
            {
                if(Type.equals(Weakness))
                {
                    return true;
                }
            }
        }
        return false;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EveSound = MediaPlayer.create(this, R.raw.evolutionsound);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        SwitchButton = findViewById(R.id.SwitchButton);
        myPokemonTitles = new String[50];
        myPokemonimages = new int[50];
        MyPokemonPowers = new String[50];
        MyPokemonDescs = new String[50];
        MyPokemon = new PokemonTracker[50];
        adapter = new MyAdapter(this, mTitle, mDescription, images);
        myPokemonAdapter = new MyPokemonAdapter(this);
        ExpAdapter = new TrackerAdapter(this);
        listView.setAdapter(adapter);
        SetClickToAdd();
        SwitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwitchView();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("int", 1);
    }


    private void SetClickToBattleEnemy() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BattleScene(ChosenPokemonID,(int)id);
            }
        });
    }




    private void SetClickToAdd() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("CLICKED : "+id);
                myPokemonTitles[PokeCounter] = mTitle[(int)id];
                MyPokemonDescs[PokeCounter] = mDescription[(int)id];
                myPokemonimages[PokeCounter] = images[(int)id];
                MyPokemon[PokeCounter] = new PokemonTracker(mDescription[(int)id],PokeCounter,(int)(id));
                MyPokemonPowers[PokeCounter] = String.valueOf(MyPokemon[PokeCounter].getpower());
                PokeCounter++;
                System.out.println("My Pokemon : ");
                for (int P = 0; P < PokeCounter; P++) {
                    System.out.println((P+1)+". "+myPokemonTitles[P]);
                }
            }
        });
    }

    private void SetClickToLevel() {
        LevelPokemon.setPressed(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(MyPokemon[(int)id]!=null){
                    LevelUp((int)id);
                    SetClickToNothing();
                }
            }
        });
    }

    private void SetClickToKill() {
        KillPokemon.setPressed(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyPokemon[(int)id].Kill();
                myPokemonAdapter.notifyDataSetChanged();
                SetClickToNothing();
            }
        });
    }

    private void SetClickToBattle() {
        BattleButton.setPressed(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //CHANGED
                BattleScene(MyPokemon[(int)id].GetBigID(),-1);
                ChosenPokemonID = MyPokemon[(int)id].GetBigID();
                myPokemonAdapter.notifyDataSetChanged();
                SetClickToNothing();
            }
        });
    }

    private void SetClickToNothing() {
        SwapPokemon.setPressed(false);
        KillPokemon.setPressed(false);
        LevelPokemon.setPressed(false);
        BattleButton.setPressed(false);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
    }

    private void SetClickToSwap() {
        Swap1 = -1;
        Swap2 = -1;
        SwapPokemon.setPressed(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(Swap1<0)
                    Swap1 = (int)id;
                else
                {
                    Swap2 = (int)id;
                    swapPokemon();
                    SetClickToNothing();
                }
            }
        });
    }

    private void swapPokemon(){
        //Swap Images
        int temp = myPokemonimages[Swap1];
        myPokemonimages[Swap1] = myPokemonimages[Swap2];
        myPokemonimages[Swap2] = temp;

        //Swap Descs
        String temp2 = MyPokemonDescs[Swap1];
        MyPokemonDescs[Swap1] = MyPokemonDescs[Swap2];
        MyPokemonDescs[Swap2] = temp2;

        //Swap Titles
        temp2 = myPokemonTitles[Swap1];
        myPokemonTitles[Swap1] = myPokemonTitles[Swap2];
        myPokemonTitles[Swap2] = temp2;

        //Swap Powers
        temp2 = MyPokemonPowers[Swap1];
        MyPokemonPowers[Swap1] = MyPokemonPowers[Swap2];
        MyPokemonPowers[Swap2] = temp2;

        //Swap Trackers
        PokemonTracker temp3 = MyPokemon[Swap1];
        MyPokemon[Swap1] = MyPokemon[Swap2];
        MyPokemon[Swap2] = temp3;
        if(MyPokemon[Swap1]!=null)
            MyPokemon[Swap1].setPokeID(Swap1);
        if(MyPokemon[Swap2]!=null)
            MyPokemon[Swap2].setPokeID(Swap2);

        myPokemonAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int myInt = savedInstanceState.getInt("int");
    }

    public class PokemonTracker {
        private String PokeType;
        private String PokeWeakness;
        private int currExp;
        private int Level;
        private int MaxExp;
        private int DamageBonus;
        private int Power;
        private int NextEv;
        private int NextPower;
        private int PokeID;
        private boolean Alive;
        private boolean IsShiny;
        private boolean dontplay;
        private int BigListID;


        public PokemonTracker(String desc, int pokecounter,int ID) {
            IsShiny = false;
            Alive = true;
            NextEv = 0;
            NextPower = 100;
            dontplay = false;
            BigListID = ID;
            CheckEvolve(desc);
            myPokemonTitles[pokecounter] = myPokemonTitles[pokecounter].split(":")[1];
            PokeType = Types[ID];
            PokeWeakness = Weaknesses[ID];
            double Shiny = Math.floor(Math.random() * 100);
            if(Shiny > 89) {
                Power = getPower(desc)+1;
                IsShiny = true;
                myPokemonTitles[pokecounter] += " Shiny";
                myPokemonimages[pokecounter] = shinyimages[ID];
                if (NextEv > 0) {
                    MyPokemonDescs[pokecounter] = "Power : " + Power + ", Evolves into:" + NextEv;
                }
                else{
                    MyPokemonDescs[pokecounter] = "Power : " + Power;
                }
            }
            else if(Shiny < 5){
                Power = getPower(desc)-1;
                myPokemonTitles[pokecounter] += " Shitty";
                if (NextEv > 0)
                    MyPokemonDescs[pokecounter] = "Power : "+Power+", Evolves into:"+NextEv;
                else
                    MyPokemonDescs[pokecounter] = "Power : "+Power;
            }
            else
                Power = getPower(desc);
            currExp = 0;
            Level = 1;
            DamageBonus = 0;
            MaxExp = (3*Power)-2;
            PokeID = pokecounter;
        }
        public int GetBigID(){
            return BigListID;
        }


        public void setPokeID(int pokeID) {
            PokeID = pokeID;
        }

        public void Kill(){
            if(Alive)
                Alive = false;
            else
                Alive = true;
        }

        public void LevelUp() {
            Level++;
            DamageBonus++;
            Power++;
            if (Power >= NextPower) {
                if(!dontplay)
                    EveSound.start();
                if(IsShiny){
                    myPokemonimages[PokeID] = shinyimages[NextEv-1];
                    myPokemonTitles[PokeID] = mTitle[NextEv-1].split(":")[1]+" Shiny";
                }
                else {
                    myPokemonimages[PokeID] = images[NextEv-1];
                    myPokemonTitles[PokeID] = mTitle[NextEv-1].split(":")[1];
                }
                CheckEvolve(mDescription[NextEv-1]);
            }
            if (NextEv > 0)
                MyPokemonDescs[PokeID] = "Power : "+Power+", Evolves into:"+NextEv;
            else
                MyPokemonDescs[PokeID] = "Power : "+Power;
            myPokemonAdapter.notifyDataSetChanged();
        }

        private void CheckEvolve (String liadomo) {
            if(liadomo.contains("Evolves")){
                int NextEv = Integer.parseInt(liadomo.split(":")[2]);
                this.NextEv = NextEv;
                NextPower = getPower(mDescription[NextEv-1]);
            }
            else
            {
                dontplay = true;
            }
        }

        private int getPower (String Desc) {
            String Parsed =  Desc.split(",")[0];
            return Integer.parseInt(Parsed.substring(Parsed.length()-1));
        }

        private int getpower(){
            return Power;
        }



        public void setCurrExp(int currExp) {
            this.currExp = currExp;
        }

        public int getLevel() {
            return Level;
        }

        public void setLevel(int level) {
            Level = level;
        }

        public int getMaxExp() {
            return MaxExp;
        }

        public void setMaxExp(int maxExp) {
            MaxExp = maxExp;
        }

        public int getDamageBonus() {
            return DamageBonus;
        }

        public void setDamageBonus(int damageBonus) {
            DamageBonus = damageBonus;
        }

        public int getCurrExp() {
            return currExp;
        }


    }

    private void LevelUp(int id) {
        MyPokemon[id].LevelUp();
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            System.out.println("MyAdapter");
            System.out.println(c);
            System.out.println(R.layout.row);
            System.out.println(R.id.textView1);
            System.out.println(title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);




            return row;
        }
    }

    class TrackerAdapter extends ArrayAdapter<String> {
        Context context;

        TrackerAdapter (Context c) {
            super(c, R.layout.buttonlistush, R.id.Bonus, MyPokemonPowers);
            this.context = c;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.buttonrowush, parent, false);
            TextView PosNum = row.findViewById(R.id.PositionButton);
            PosNum.setText(String.valueOf(position));
            return row;
        }
    }

    class MyPokemonAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];
        View newrow;

        MyPokemonAdapter (Context c) {
            super(c, R.layout.row, R.id.textView1, myPokemonTitles);
            this.context = c;
            this.rTitle = myPokemonTitles;
            this.rDescription = MyPokemonDescs;
            this.rImgs = myPokemonimages;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            newrow = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = newrow.findViewById(R.id.image);
            TextView myTitle = newrow.findViewById(R.id.textView1);
            TextView myDescription = newrow.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            if(MyPokemon[position]!=null && !MyPokemon[position].Alive)
                newrow.setBackgroundColor(Color.DKGRAY);
            if(rTitle[position] != null)
                myTitle.setText((position+1)+": "+rTitle[position]);
            myDescription.setText(rDescription[position]);
            return newrow;
        }

        public void UpdatePokemon(int Position){
            ImageView images = newrow.findViewById(R.id.image);
            TextView myTitle = newrow.findViewById(R.id.textView1);
            TextView myDescription = newrow.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[Position]);
            myTitle.setText((Position+1)+": "+rTitle[Position]);
            myDescription.setText(rDescription[Position]);
        }
    }


//    class MyPokemonAdapter extends ArrayAdapter<String> {
//
//        Context context;
//        String rTitle[];
//        String rDescription[];
//        int rImgs[];
//
//        MyPokemonAdapter (Context c) {
//            super(c, R.layout.newrow, R.id.textView1, myPokemonTitles);
//            System.out.println("MyPokeAdapter");
//            System.out.println(c);
//            System.out.println(R.layout.newrow);
//            System.out.println(R.id.textView1);
//            System.out.println(myPokemonTitles);
//            this.context = c;
//            this.rTitle = myPokemonTitles;
//            this.rDescription = MyPokemonDescs;
//            this.rImgs = myPokemonimages;
//
//        }
//
//        @NonNull
//        @Override
//        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View newrow = layoutInflater.inflate(R.layout.newrow, parent, false);
//            ImageView images = newrow.findViewById(R.id.image);
//            TextView myTitle = newrow.findViewById(R.id.textView1);
//            TextView myDescription = newrow.findViewById(R.id.textView2);
//
//            // now set our resources on views
//            images.setImageResource(rImgs[position]);
//            myTitle.setText(rTitle[position]);
//            myDescription.setText(rDescription[position]);
//            return newrow;
//        }
//    }
}
