package com.dicoding.popcorn.utils

import com.dicoding.popcorn.data.ContentEntity
import com.dicoding.popcorn.data.MovieEntity

object DataDummy {

    fun generateDummyMovies(): ArrayList<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        var movie = MovieEntity("m14", "Avengers: Endgame", "8.4", "2019", "Action, Adventure, Drama", "https://image-cdn.hypb.st/https%3A%2F%2Fhypebeast.com%2Fimage%2F2019%2F03%2Fmarvel-avengers-endgame-character-posters-1.jpg?quality=95&w=1170&cbr=1&q=90&fit=max", "3h 1min")
        movie.detail = ContentEntity("After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.", "Anthony Russo, Joe Russo", "Christopher Markus, Stephen McFeely, etc", "Robert Downey Jr., Chris Evans, Mark Ruffalo, etc")
        movies.add(movie)

        movie = MovieEntity("m15", "The Conjuring", "7.5", "2013", "Horror, Mystery, Thriller", "https://wickedhorror.com/wp-content/uploads/2014/04/The-Conjuring-large-864x467.jpg", "1h 52min")
        movie.detail = ContentEntity("Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse.", "James Wan", "Chad Hayes, Carey W. Hayes, etc", "Patrick Wilson, Vera Farmiga, Ron Livingston, etc")
        movies.add(movie)

        movie = MovieEntity("m16", "Non-Stop", "6.9", "2014", "Action, Mystery, Thriller", "https://cdn-2.tstatic.net/jakarta/foto/bank/images/poster-film-non-stop-2014.jpg", "1h 46min")
        movie.detail = ContentEntity("An air marshal springs into action during a transatlantic flight after receiving a series of text messages demanding \$150 million into an off-shore account, or someone will die every 20 minutes.", "Jaume Collet-Serra", "John W. Richardson, Christopher Roach, etc", "Liam Neeson, Julianne Moore, Scoot McNairy, etc")
        movies.add(movie)

        movie = MovieEntity("m17", "Frozen", "7.4", "2013", "Animation, Adventure, Comedy", "https://wallpapercave.com/wp/wp1984718.jpg", "1h 42min")
        movie.detail = ContentEntity("When the newly crowned Queen Elsa accidentally uses her power to turn things into ice to curse her home in infinite winter, her sister Anna teams up with a mountain man, his playful reindeer, and a snowman to change the weather condition.", "Chris Buck, Jennifer Lee", "Jennifer Lee, Hans Christian Andersen, etc", "Kristen Bell, Idina Menzel, Jonathan Groff, etc")
        movies.add(movie)

        movie = MovieEntity("m17", "The Greatest Showman", "7.6", "2017", "Biography, Drama, Musical", "https://wallpapercave.com/wp/wp5469836.jpg", "1h 45min")
        movie.detail = ContentEntity("Celebrates the birth of show business and tells of a visionary who rose from nothing to create a spectacle that became a worldwide sensation.", "Michael Gracey", "Jenny Bicks, Bill Condon, etc", "Hugh Jackman, Michelle Williams, Zac Efron, etc")
        movies.add(movie)

        movie = MovieEntity("m18", "Kingsman: The Golden Circle", "6.7", "2017", "Action, Adventure, Comedy", "https://www.wallpapersdsc.net/wp-content/uploads/2016/08/Kingsman-The-Golden-Circle-Widescreen.jpg", "2h 21min")
        movie.detail = ContentEntity("After the Kingsman's headquarters are destroyed and the world is held hostage, an allied spy organisation in the United States is discovered. These two elite secret organisations must band together to defeat a common enemy.", "Matthew Vaughn", "Jane Goldman, Matthew Vaughn, etc", "Taron Egerton, Colin Firth, Mark Strong, etc")
        movies.add(movie)

        movie = MovieEntity("m19", "Demon Slayer the Movie: Mugen Train", "8.3", "2020", "Animation, Action, Adventure", "https://wallpapercave.com/wp/wp7836447.png", "1h 57min")
        movie.detail = ContentEntity("After his family was brutally murdered and his sister turned into a demon, Tanjiro Kamado's journey as a demon slayer began. Tanjiro and his comrades embark on a new mission aboard the Mugen Train, on track to despair.", "Haruo Sotozaki", "Koyoharu Gotouge, Ufotable", "Bryce Papenbrook, Zach Aguilar, Abby Trott, etc")
        movies.add(movie)

        movie = MovieEntity("m20", "Spider-Man: Far from Home", "7.5", "2019", "Action, Adventure, Sci-Fi", "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/10af0b39-a57e-4f10-aeb1-fd388299ed5b/dd30sej-ba00f8a2-fdcf-48ad-8681-e507010cba43.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvMTBhZjBiMzktYTU3ZS00ZjEwLWFlYjEtZmQzODgyOTllZDViXC9kZDMwc2VqLWJhMDBmOGEyLWZkY2YtNDhhZC04NjgxLWU1MDcwMTBjYmE0My5wbmcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.zo5r_8YpyD_sUAJZePooQIS535StlC06FeYVg6vhCWI", "2h 9min")
        movie.detail = ContentEntity("Following the events of Avengers: Endgame (2019), Spider-Man must step up to take on new threats in a world that has changed forever.", "Jon Watts", " Chris McKenna, Erik Sommers, etc", "Tom Holland, Samuel L. Jackson, Jake Gyllenhaal, etc")
        movies.add(movie)

        movie = MovieEntity("m21", "Kimi no Na Wa", "8.4", "2016", "Animation, Drama, Fantasy", "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/03f50f1d-7de3-4578-b680-bbce414bb22d/dajydsn-f0954842-d52f-4f59-9800-d236c3c3dfcc.jpg/v1/fill/w_1600,h_900,q_75,strp/_update_1___multi_sourced_4k__kimi_no_na_wa_by_assassinwarrior_dajydsn-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3siaGVpZ2h0IjoiPD05MDAiLCJwYXRoIjoiXC9mXC8wM2Y1MGYxZC03ZGUzLTQ1NzgtYjY4MC1iYmNlNDE0YmIyMmRcL2Rhanlkc24tZjA5NTQ4NDItZDUyZi00ZjU5LTk4MDAtZDIzNmMzYzNkZmNjLmpwZyIsIndpZHRoIjoiPD0xNjAwIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.1SiUC-HT7-zMs0EvALb-RfiZoxDzcx6Z55FqcGwmmwQ", "1h 46min")
        movie.detail = ContentEntity("Two strangers find themselves linked in a bizarre way. When a connection forms, will distance be the only thing to keep them apart?", "Makoto Shinkai", "Makoto Shinkai, Makoto Shinkai, etc", "Ryûnosuke Kamiki, Mone Kamishiraishi, Ryô Narita, etc")
        movies.add(movie)

        movie = MovieEntity("m22", "Violet Evergarden: The Movie", "8.3", "2020", "Animation, Drama, Fantasy", "https://i2.wp.com/animesaku.com/wp-content/uploads/2020/03/Violet-Evergarden-Movie-2020-1.jpg?fit=1600%2C900&ssl=1", "2h 20min")
        movie.detail = ContentEntity("After the aftermath of a war, a young girl who was used as a 'tool' for war learned to live. With the scars of burns , she goes back to her past to feel the true feelings of the Major's ,\"I love you.\"", "Taichi Ishidate", "Kana Akatsuki, Reiko Yoshida", "Yui Ishikawa, Daisuke Namikawa, Takehito Koyasu, etc")
        movies.add(movie)

        return movies
    }

    fun generateDummyTVShows(): ArrayList<MovieEntity> {
        val tvshows = ArrayList<MovieEntity>()

        var tvshow = MovieEntity("t13", "Shingeki no Kyojin", "8.9", "2013", "Animation, Action, Adventure","https://wallpapercave.com/wp/wp1837539.jpg","24min")
        tvshow.detail = ContentEntity("After his hometown is destroyed and his mother is killed, young Eren Jaeger vows to cleanse the earth of the giant humanoid Titans that have brought humanity to the brink of extinction.", "-", "-", "Yûki Kaji, Marina Inoue, Yui Ishikawa, etc")
        tvshows.add(tvshow)

        tvshow = MovieEntity("t14", "SKY Castle", "8.7", "2018", "Drama, Mystery", "https://asianwiki.com/images/2/28/SKY_Castle-GP.jpg", "1h 15min")
        tvshow.detail = ContentEntity("A satirical drama that closely looks at the materialistic desires of the upper-class parents in South Korea and how they ruthlessly secure the successes of their families at the cost of destroying others' lives.", "-", "-", "Jung-ah Yum, Tae-ran Lee, Yun Se-ah, etc")
        tvshows.add(tvshow)

        tvshow = MovieEntity("t15", "Kingdom", "8.4", "2019", "Action, Drama, Horror", "https://occ-0-999-2705.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABU9bHervQ-EtmiZVt8zsrEhQobTSgzXGHPmHaap3Xg8K7Nk5yhuD3uLDBeBBcoqFrPlyvlzaqxPGe7KTisTxFotu0lEJ.jpg?r=e6e", " 45min")
        tvshow.detail = ContentEntity("While strange rumors about their ill King grip a kingdom, the crown prince becomes their only hope against a mysterious plague overtaking the land.", "-", "-", "Ju Ji-Hoon, Bae Doona, Kim Sungkyu, etc")
        tvshows.add(tvshow)

        tvshow = MovieEntity("t16", "SpongeBob SquarePants", "8.2", "1999", "Animation, Comedy, Family", "https://lovelytab.com/wp-content/uploads/2018/11/BC31E7E4-06FF-40A1-8B75-E812DE06F54B-1024x608.jpg", "23min")
        tvshow.detail = ContentEntity("The misadventures of a talking sea sponge who works at a fast food restaurant, attends a boating school, and lives in an underwater pineapple.", "-", "Stephen Hillenburg, Tim Hill, Nick Jennings, etc", "Tom Kenny, Bill Fagerbakke, Rodger Bumpass, etc")
        tvshows.add(tvshow)

        tvshow = MovieEntity("t17", "Demon Slayer: Kimetsu No Yaiba", "8.7", "2019", "Animation, Action, Fantasy", "https://coloringforprints.xyz/wp-content/uploads/2020/04/kimetsu-no-yaiba-wallpaper-iphone-3-1024x576.jpg", " 25min")
        tvshow.detail = ContentEntity("A family is attacked by demons and only two members survive - Tanjiro and his sister Nezuko, who is turning into a demon slowly. Tanjiro sets out to become a demon slayer to avenge his family and cure his sister.", "-", "-", "Natsuki Hanae, Zach Aguilar, Abby Trott, etc")
        tvshows.add(tvshow)

        tvshow = MovieEntity("t18", "The Haunting of Hill House", "8.6", "2018", "Drama, Horror, Mystery", "https://www.layar.id/wp-content/uploads/2018/09/Haunting-Hill-House-1000-08.jpg", " 9h 32min")
        tvshow.detail = ContentEntity("Flashing between past and present, a fractured family confronts haunting memories of their old home and the terrifying events that drove them from it.", "-", "Mike Flanagan", "Michiel Huisman, Carla Gugino, Henry Thomas, etc")
        tvshows.add(tvshow)

        tvshow = MovieEntity("t19", "Locke & Key", "7.4", "2020", "Drama, Fantasy, Horror", "https://tvline.com/wp-content/uploads/2019/12/locke-and-key-netflix-teaser.jpg?w=620", "48min")
        tvshow.detail = ContentEntity("After their father is murdered under mysterious circumstances, the three Locke siblings and their mother move into their ancestral home, Keyhouse, which they discover is full of magical keys that may be connected to their father's death.", "-", "Meredith Averill, Aron Eli Coleite, Carlton Cuse", "Darby Stanchfield, Connor Jessup, Emilia Jones, etc")
        tvshows.add(tvshow)

        tvshow = MovieEntity("t20", "The Umbrella Academy", "8.0", "2019", "Action, Adventure, Comedy", "https://upload.wikimedia.org/wikipedia/en/2/2d/The_Umbrella_Academy_logo.jpg", " 1h")
        tvshow.detail = ContentEntity("A family of former child heroes, now grown apart, must reunite to continue to protect the world.", "-", "Steve Blackman, Jeremy Slater", "Elliot Page, Tom Hopper, David Castañeda, etc")
        tvshows.add(tvshow)

        tvshow = MovieEntity("t21", "JoJo's Bizarre Adventure", "8.4", "2012", "Animation, Action, Adventure", "https://uk-anime.net/Images/jojosdcpt1-1.jpg", " 30min")
        tvshow.detail = ContentEntity("The story of the Joestar family, who are possessed with intense psychic strength, and the adventures each member encounters throughout their lives.", "-", "-", "Matthew Mercer, Unshô Ishizuka, Daisuke Ono, etc")
        tvshows.add(tvshow)

        tvshow = MovieEntity("t22", "Jujutsu Kaisen", "8.7", "2020", "Animation, Action, Adventure", "https://media.comicbook.com/2020/12/jujutsu-kaisen-kyoto-goodwill-event-arc-key-visual-1249732-1280x0.jpeg", "24min")
        tvshow.detail = ContentEntity("A boy swallows a cursed talisman - the finger of a demon - and becomes cursed himself. He enters a shaman's school to be able to locate the demon's other body parts and thus exorcise himself.", "-", "-", "Junya Enoki, Yûichi Nakamura, Asami Seto, etc")
        tvshows.add(tvshow)

        return  tvshows
    }
}