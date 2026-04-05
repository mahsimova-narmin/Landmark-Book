package com.narminmahsimova.landmarkbookkotlin

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.narminmahsimova.landmarkbookkotlin.databinding.ActivityMainBinding
var chosenLandmark: Landmark? = null
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList: ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        landmarkList = ArrayList<Landmark>()

        val flameTower = Landmark("Flame Towers", "The Flame Towers (Azerbaijani: Alov qüllələri) are a trio of flame-shaped skyscrapers in Baku, Azerbaijan. Completed in 2012 at a height of 182 m (597 ft), the complex symbolizes the \"Land of Fire.\" The towers house a hotel, residential apartments, and office spaces, and are famous for a night-time LED display that mimics flickering flames.", R.drawable.flametowers)
        val blueMosque = Landmark("Blue Mosque", "The Sultan Ahmed Mosque, known as the Blue Mosque, is a historic imperial mosque in Istanbul, Turkey. Completed in 1617 during the reign of Ahmed I, it is famous for its unique six minarets and its interior decorated with over 20,000 blue İznik tiles. As a UNESCO World Heritage site, it remains a defining landmark of the city's skyline and a masterpiece of Ottoman architecture.", R.drawable.bluemosque)
        val colosseum = Landmark("Colosseum", "The Colosseum, originally the Flavian Amphitheatre, is an iconic oval amphitheatre in the heart of Rome, Italy. Completed in 80 AD under Emperor Titus, it is the largest ancient amphitheatre ever built, once hosting up to 80,000 spectators for gladiatorial games. Constructed of travertine and brick, it remains a global symbol of Roman engineering and is recognized as one of the New Seven Wonders of the World.", R.drawable.colosseum)
        val pantheon = Landmark("Pantheon", "The Pantheon is a former Roman temple and current Catholic basilica in Rome, Italy, completed around 126 AD during the reign of Emperor Hadrian. It is world-renowned for its massive unreinforced concrete dome, which remains the largest of its kind, featuring a central opening called the oculus. As one of the best-preserved monuments of Ancient Rome, it serves as a masterpiece of classical architecture and the burial site for several Italian kings and the painter Raphael.", R.drawable.pantheon)
        val pyramid = Landmark("Great Pyramid of Giza", "The Great Pyramid of Giza is the oldest and largest of the three pyramids in Giza, Egypt, completed around 2560 BC as a tomb for Pharaoh Khufu. Standing as the only surviving member of the Seven Wonders of the Ancient World, it was the world's tallest man-made structure for over 3,800 years. Built using an estimated 2.3 million limestone blocks, it remains a global marvel of ancient engineering and a central symbol of Egyptian civilization.", R.drawable.pyramids)
        val itsukushima = Landmark("Itsukushima Shrine", "The Itsukushima Shrine is a Shinto shrine on the island of Itsukushima (Miyajima), Japan, best known for its \"floating\" torii gate. Established in the 6th century and rebuilt in its current form in 1168, the complex is built over water to appear as if it is floating during high tide. It is a UNESCO World Heritage site and a National Treasure of Japan, celebrated as one of the country's most iconic views and a masterpiece of traditional architecture integrated with nature.", R.drawable.itsukushima_shrine)
        val namdaemun = Landmark("Sungnyemun Gate", "Sungnyemun Gate, also known as Namdaemun, is a historic gate located in the heart of Seoul, South Korea. Completed in 1398 during the Joseon Dynasty, it served as the main southern entrance to the walled city and is designated as South Korea's National Treasure No. 1. The gate is renowned for its traditional multi-tiered wooden pagoda design and stone base. After suffering severe fire damage in 2008, it was meticulously restored and reopened in 2013, remaining a powerful symbol of Korean national identity and resilience.", R.drawable.namdaemun)
        val greatWall = Landmark("Great Wall of China", "The Great Wall of China is a series of ancient fortifications stretching across the historical northern borders of China. Primarily built between the 14th and 17th centuries during the Ming Dynasty, it was designed to protect the empire from nomadic invasions and to control trade along the Silk Road. Spanning over 21,196 km (13,171 mi) including all its branches, it is a UNESCO World Heritage site and is widely considered one of the greatest feats of defensive architecture in human history.", R.drawable.greatwall)
        val eiffelTower = Landmark("Eiffel Tower", "The Eiffel Tower (French: Tour Eiffel) is a wrought-iron lattice tower located on the Champ de Mars in Paris, France. Constructed from 1887 to 1889 as the centerpiece of the 1889 World's Fair, it was named after the engineer Gustave Eiffel. Standing at 330 meters (1,083 ft), it was the world's tallest man-made structure until 1930. Today, it is a global cultural icon, one of the most recognizable structures in the world, and the most-visited paid monument on Earth.", R.drawable.eiffel)
        val bigBen = Landmark("Big Ben", "Big Ben is the nickname for the Great Bell of the striking clock at the north end of the Palace of Westminster in London, England. Completed in 1859, the tower—officially renamed the Elizabeth Tower in 2012—stands at 96 meters (315 ft) and is a global symbol of British cultural heritage. Renowned for its reliability and its massive four-faced chiming clock, it remains one of the most famous landmarks in the world and a centerpiece of the UK's democratic history.", R.drawable.bigben)
        val libertyStatue = Landmark("Statue of Liberty", "The Statue of Liberty (Liberty Enlightening the World) is a colossal neoclassical sculpture on Liberty Island in New York Harbor, United States. A gift from the people of France to the U.S., it was designed by Frédéric Auguste Bartholdi and dedicated in 1886. Standing at 93 meters (305 ft) from ground to torch, the copper statue represents Libertas, the Roman goddess of liberty, and remains a global symbol of freedom and a welcoming signal to immigrants arriving by sea.", R.drawable.statueofliberty)
        val cathedral = Landmark("Saint Basil's Cathedral", "Saint Basil's Cathedral is a Christian church in Red Square, Moscow, and one of the most recognizable symbols of Russia. Built between 1555 and 1561 by order of Ivan the Terrible, it was designed to commemorate the capture of Kazan and Astrakhan. The cathedral is famous for its unique, colorful \"onion domes\" and its complex layout of nine chapels built around a central core. Now a museum and a UNESCO World Heritage site, it remains a masterpiece of Russian architecture and a global cultural icon.", R.drawable.stbasilcathedral)
        val moai = Landmark("Moai", "The Moai are monolithic human figures carved by the Rapa Nui people on Easter Island, Chile, between 1250 and 1500 AD. Carved primarily from volcanic ash, nearly 900 statues are spread across the island, with the largest weighing over 80 tons. These massive figures, many of which sit on stone platforms called ahu, are believed to represent the living faces of deified ancestors. They remain a global mystery of ancient engineering and a central symbol of Polynesian cultural heritage.", R.drawable.moai)
        val tajMahal = Landmark("Taj Mahal", "The Taj Mahal is an ivory-white marble mausoleum on the right bank of the river Yamuna in Agra, India. It was commissioned in 1632 by the Mughal emperor Shah Jahan to house the tomb of his favorite wife, Mumtaz Mahal; it also houses the tomb of Shah Jahan himself. The tomb is the centerpiece of a 17-hectare (42-acre) complex, which includes a mosque and a guest house, and is set in formal gardens bounded on three sides by a crenellated wall. The Taj Mahal was designated as a UNESCO World Heritage Site in 1983 for being \"the jewel of Muslim art in India and one of the universally admired masterpieces of the world's heritage.\"", R.drawable.taj_mahal)

        //Inefficient method
        //val flameBitmap = BitmapFactory.decodeResource(resources,R.drawable.flametowers)

        landmarkList.add(flameTower)
        landmarkList.add(blueMosque)
        landmarkList.add(colosseum)
        landmarkList.add(pantheon)
        landmarkList.add(pyramid)
        landmarkList.add(itsukushima)
        landmarkList.add(namdaemun)
        landmarkList.add(greatWall)
        landmarkList.add(eiffelTower)
        landmarkList.add(bigBen)
        landmarkList.add(libertyStatue)
        landmarkList.add(cathedral)
        landmarkList.add(moai)
        landmarkList.add(tajMahal)

        val landmarkAdapter = LandmarkAdapter(landmarkList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = landmarkAdapter

    }
}