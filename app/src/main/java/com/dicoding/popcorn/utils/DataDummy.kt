package com.dicoding.popcorn.utils

import com.dicoding.popcorn.data.ContentEntity
import com.dicoding.popcorn.data.DetailEntity
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

    fun generateDummyRemoteMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        var movie = MovieEntity("458576", "Monster Hunter",  "7.2", "2020", "14, 28, 12", "https://image.tmdb.org/t/p/w500/uwjaCH7PiWrkz7oWJ4fcL3xGrb0.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("649087", "Red Dot", "6.2", "2021", "18, 53", "https://image.tmdb.org/t/p/w500/xZ2KER2gOHbuHP2GJoODuXDSZCb.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("581389", "Space Sweepers", "7.3", "2021", "18, 14, 878", "https://image.tmdb.org/t/p/w500/bmemsraCG1kIthY74NjDnnLRT2Q.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("464052", "Wonder Woman 1984", "6.9", "2020", "14, 28, 12", "https://image.tmdb.org/t/p/w500/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",  "-")
        movies.add(movie)

        movie = MovieEntity("602269", "The Little Things", "6.4", "2021", "53, 80", "https://image.tmdb.org/t/p/w500/c7VlGCCgM9GZivKSzBgzuOVxQn7.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("599281", "Fear of Rain", "7.4", "2021", "53, 27, 18", "https://image.tmdb.org/t/p/w500/b2shaNA4F8zNIwoRYr33lPTiFfl.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("775996", "Outside the Wire", "6.5", "2021", "53, 28, 878", "https://image.tmdb.org/t/p/w500/6XYLiMxHAaCsoyrVo38LBWMw2p8.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("587996", "Below Zero", "6.4", "2021", "28, 80, 53", "https://image.tmdb.org/t/p/w500/dWSnsAGTfc8U27bWsy2RfwZs0Bs.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("522444", "Black Water: Abyss 5", "2020", "27, 53, 12", "https://image.tmdb.org/t/p/w500/95S6PinQIvVe4uJAd82a2iGZ0rA.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("651571", "Breach", "4.5", "2020", "878, 28", "https://image.tmdb.org/t/p/w500/13B6onhL6FzSN2KaNeQeMML05pS.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("604822", "Vanguard", "6.5", "2020", "28, 12, 80", "https://image.tmdb.org/t/p/w500/vYvppZMvXYheYTWVd8Rnn9nsmNp.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("590706", "Jiu Jitsu", "5.3", "2020", "14, 28, 878", "https://image.tmdb.org/t/p/w500/eLT8Cu357VOwBVTitkmlDEg32Fs.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("664767", "Mortal Kombat Legends: Scorpion's Revenge", "8.4", "2020", "14, 28, 12, 16", "https://image.tmdb.org/t/p/w500/4VlXER3FImHeFuUjBShFamhIp9M.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("581387", "Ashfall", "6.6", "2019", "28, 12, 53", "https://image.tmdb.org/t/p/w500/zoeKREZ2IdAUnXISYCS0E6H5BVh.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("560144", "Skylines", "5.7", "2020", "878, 28", "https://image.tmdb.org/t/p/w500/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("508442", "Soul", "8.3", "2020", "10751, 16, 35, 18, 10402, 14", "https://image.tmdb.org/t/p/w500/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("714277", "The Funeral Home", "0", "2021-04-15", "27, 35", "https://image.tmdb.org/t/p/w500/1rlgIzw129hEl46bFaJZ7wpEEZZ.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("529203", "The Croods: A New Age", "7.6", "2020", "10751, 12, 14, 16", "https://image.tmdb.org/t/p/w500/tK1zy5BsCt1J4OzoDicXmr0UTFH.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("614409", "To All the Boys: Always and Forever", "8", "2021", "35, 18, 10749", "https://image.tmdb.org/t/p/w500/zdkJs9j6yKo9di0kjtctM01fSMv.jpg", "-")
        movies.add(movie)

        movie = MovieEntity("539885", "Ava", "5.6", "2020-07-02", "28, 80, 18, 53", "https://image.tmdb.org/t/p/w500/qzA87Wf4jo1h8JMk9GilyIYvwsA.jpg", "-")
        movies.add(movie)

        return movies
    }

    fun generateDummyRemoteTVShow(): List<MovieEntity> {
        val tvShows = ArrayList<MovieEntity>()

        var tvShow = MovieEntity("85271", "WandaVision", "8.5", "2021-01-15", "[10765, 9648, 18]", "https://image.tmdb.org/t/p/w500/glKDfE6btIRcVB5zrjspRIs4r52.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("69050", "Riverdale", "8.6", "2017-01-26", "[9648, 18, 80]", "https://image.tmdb.org/t/p/w500/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("97513", "The Boarding School: Las Cumbres", "7.4", "2021-02-19", "[18, 9648]", "https://image.tmdb.org/t/p/w500/kl07N07l4XNjXF48oujzWXs40Dw.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("1402", "The Walking Dead", "8", "2010-10-31", "[10759, 18, 10765]", "https://image.tmdb.org/t/p/w500/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("71712", "The Good Doctor", "8.6", "2017-09-25", "[18]", "https://image.tmdb.org/t/p/w500/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("63174", "Lucifer", "8.5", "2016-01-25", "[80, 10765]", "https://image.tmdb.org/t/p/w500/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("1416", "Grey's Anatomy", "8.2", "2005-03-27", "[18]", "https://image.tmdb.org/t/p/w500/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("79460", "Legacies", "8.6", "2018-10-25", "[10765, 18]", "https://image.tmdb.org/t/p/w500/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("77169", "Cobra Kai", "8.1", "2018-05-02", "[10759, 18]", "https://image.tmdb.org/t/p/w500/obLBdhLxheKg8Li1qO11r2SwmYO.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("67133", "MacGyver", "7.1", "2016-09-23", "[18, 10759]", "https://image.tmdb.org/t/p/w500/2zAogx9dmSAu2HYxbWzHe4ZaNY5.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("44217", "Vikings", "8", "2013-03-03", "[10759, 18]", "https://image.tmdb.org/t/p/w500/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("114695", "Marvel Studios: Legends", "7.6", "2021-01-08", "[99]", "https://image.tmdb.org/t/p/w500/EpDuYIK81YtCUT3gH2JDpyj8Qk.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("82856", "The Mandalorian", "8.5", "2019-11-12", "[10765, 10759]", "https://image.tmdb.org/t/p/w500/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("18165", "The Vampire Diaries", "8.3", "2009-09-10", "[18, 10765]", "https://image.tmdb.org/t/p/w500/aBkVgChtyyJaHyZh1gfd8DbzQon.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("1399", "Game of Thrones", "8.4", "2011-04-17", "[10765, 18, 10759]", "https://image.tmdb.org/t/p/w500/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("115857", "Daughter From Another Mother", "7.5", "2021-01-20", "[35, 18]", "https://image.tmdb.org/t/p/w500/6chvnAakKI2cYW69ODBHZHm8clb.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("71728", "Young Sheldon", "8", "2017-09-25", "[35]", "https://image.tmdb.org/t/p/w500/aESxB2HblKlDzma39xVefa20pbW.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("60735", "The Flash", "7.6", "2014-10-07", "[18, 10765]", "https://image.tmdb.org/t/p/w500/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("67335", "Sin senos sí hay paraíso", "7.5", "2016-07-19", "[10759, 80, 18, 9648]", "https://image.tmdb.org/t/p/w500/ulcGG2JKjbVMQFIux1vcQGN1pQi.jpg", "-")
        tvShows.add(tvShow)

        tvShow = MovieEntity("97173", "Behind Her Eyes", "7.9", "2021-02-17", "[18]", "https://image.tmdb.org/t/p/w500/sfd90NIf778KoBFmpdBTow4xTm7.jpg", "-")
        tvShows.add(tvShow)

        return tvShows
    }

    fun generateDummyMovieDetail(): DetailEntity {
        return DetailEntity("458576", "Monster Hunter", "7.2", "2020", arrayListOf("Fantasy", "Action", "Adventure"), "https://image.tmdb.org/t/p/w500/uwjaCH7PiWrkz7oWJ4fcL3xGrb0.jpg", "1h 44min", "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
        "-", "-", "-")
    }

    fun generateDummyTVShowDetail(): DetailEntity {
        return DetailEntity("85271", "WandaVision", "8.5", "2021", arrayListOf("Sci-Fi & Fantasy", "Mystery", "Drama"), "https://image.tmdb.org/t/p/w500/glKDfE6btIRcVB5zrjspRIs4r52.jpg", "36min", "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
            "-", "-", "-")
    }
}