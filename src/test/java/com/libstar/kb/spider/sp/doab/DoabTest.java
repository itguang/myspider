package com.libstar.kb.spider.sp.doab;

import com.libstar.kb.spider.sp.doab.article.DoabArticleTask;
import com.libstar.kb.spider.sp.doab.dao.BookRepository;
import com.libstar.kb.spider.sp.doab.entity.BookEntity;
import com.libstar.kb.spider.sp.doab.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Arrays;
import java.util.List;

/**
 * @author 李增光
 * @create 2018-08-09 11:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DoabTest {

    @Autowired
    DoabArticleTask task;
    String s = "[<div itemscope itemtype=\"http://schema.org/Book\"> \n" +
            " <!-- start schema.org - search engine optimization --> \n" +
            " <div class=\"record\" id=\"record1\"> \n" +
            "  <div class=\"imageDiv\"> \n" +
            "   <img src=\"/doab?func=cover&amp;rid=16782\" width=\"110\" height=\"155\" border=\"0\"> \n" +
            "  </div>\n" +
            "  <!-- END imageDiv --> \n" +
            "  <div class=\"data\"> \n" +
            "   <b><span itemprop=\"name\">À beira da linha: formações urbanas da Noroeste Paulista </span></b> \n" +
            "   <p> </p>\n" +
            "   <div style=\"color: #585858\"> \n" +
            "    <!-- author (s) --> \n" +
            "    <strong>Authors</strong>: \n" +
            "    <a itemprop=\"author\" href=\"/doab?func=search&amp;query=au:&quot;Ghirardello, Nilson&quot;&amp;uiLanguage=en\">Ghirardello, Nilson</a> \n" +
            "    <br> \n" +
            "    <!-- End Loop_au if--> \n" +
            "    <strong>ISBN</strong>: \n" +
            "    <span itemprop=\"isbn\">9788539302420</span> \n" +
            "    <strong>Year</strong>: \n" +
            "    <span itemprop=\"datePublished\">2002</span> \n" +
            "    <strong>Pages</strong>: \n" +
            "    <span itemprop=\"numberOfPages\">235</span> \n" +
            "    <strong>DOI</strong>: 10.7476/9788539302420 \n" +
            "    <strong>Language</strong>: Portuguese \n" +
            "    <br>\n" +
            "    <strong>Publisher</strong>: \n" +
            "    <a itemprop=\"publisher\" href=\"/doab?func=publisher&amp;pId=1251&amp;uiLanguage=\">SciELO Books - Editora UNESP</a> \n" +
            "    <br>\n" +
            "    <strong>Subject</strong>: \n" +
            "    <a itemprop=\"about\" href=\"/doab?func=subject&amp;cpId=100&amp;uiLanguage=en\"> Technology (General)</a> \n" +
            "    <br>\n" +
            "    <strong>Added to DOAB on </strong>: 2015-01-27 17:03:16 \n" +
            "    <br>License: \n" +
            "    <a href=\"https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode\" target=\"blank\"><img src=\"https://i.creativecommons.org/l/by-nc-sa/3.0/80x15.png\"> </a> \n" +
            "   </div>\n" +
            "   <!-- End color #585858 --> \n" +
            "   <p> </p>\n" +
            "   <div class=\"recordLinks\" id=\"r1\"> \n" +
            "    <h1> <a href=\"javascript:void(0)\" title=\"abs1\"> <span id=\"absLabel1\">Abstract</span> </a> | <a href=\"javascript:void(0)\" title=\"kw1\"> <span id=\"kwLabel1\">Keywords</span> </a> | <a itemprop=\"url\" href=\"/doab?func=fulltext&amp;uiLanguage=en&amp;rid=16782\" target=\"_blank\">Free access</a> | <a href=\"/doab?func=checkAvailability&amp;uiLanguage=en&amp;rid=16782\" class=\"checkAvailable\" title=\"av1\">Buy the book</a> | <a href=\"javascript:void(0)\" title=\"exp1\"> <span id=\"expLabel1\">Export citation</span></a> | <a class=\"addthis_button\" href=\"http://www.addthis.com/bookmark.php?v=300\" addthis:url=\"http://www.doabooks.org/doab?func=search&amp;query=rid:16782\" addthis:title=\"DOAB: À beira da linha: formações urbanas da Noroeste Paulista\"><img style=\"border:0\" alt=\"Share\" src=\"/doabImages/addThis.gif\"> </a> </h1> \n" +
            "   </div> \n" +
            "   <!-- END recordLinks --> \n" +
            "   <div class=\"linkContent\"> \n" +
            "    <div id=\"av1\" class=\"tip dyn\">\n" +
            "     <img src=\"/doabImages/spinner.gif\"> Loading...\n" +
            "    </div> \n" +
            "    <div id=\"exp1\" class=\"tip\"> \n" +
            "     <b>Export citation</b> \n" +
            "     <p> Choose an application </p>\n" +
            "     <ul> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=referenceManager&amp;query=16782\"> Reference Manager</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=endNote&amp;query=16782\"> EndNote</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=refworks&amp;query=16782\" target=\"RefWorksMain\"> RefWorks</a> (Direct export to RefWorks)</li> \n" +
            "     </ul> \n" +
            "    </div> \n" +
            "    <div itemprop=\"description\" id=\"abs1\" class=\"tip\"> \n" +
            "     <b>Abstract</b>\n" +
            "     <p> Enfoca a formação das cidades paulistas criadas junto à antiga Companhia Estrada de Ferro Noroeste do Brasil - atual Novoeste, do início da construção da ferrovia, em 1905, até 1914, data que marca o término da ligação entre Bauru (SP) e Porto Esperança, no atual Mato Grosso do Sul. Nesse período, surgem, a partir das estações, povoados que apresentam certas constantes urbanísticas. Cidades como Lins, Penápolis e Araçatuba merecem análise detalhada. O autor verifica que nelas predominou, desde a sua origem, a lógica da especulação imobiliária e do lucro como base para a vida urbana. </p>\n" +
            "    </div> \n" +
            "    <div id=\"kw1\" class=\"tip\"> \n" +
            "     <b>Keywords</b>\n" +
            "     <p> \n" +
            "      <!-- Multi --> <a itemprop=\"keywords\" href=\"/doab?func=search&amp;uiLanguage=en&amp;query=kw:&quot;TECHNOLOGY &amp; ENGINEERING&quot;\">TECHNOLOGY &amp; ENGINEERING</a> </p>\n" +
            "    </div> \n" +
            "   </div> \n" +
            "   <!-- END linkContent --> \n" +
            "  </div> \n" +
            "  <!-- END data --> \n" +
            "  <div style=\"clear:both\"></div> \n" +
            " </div> \n" +
            " <!-- END record ---> \n" +
            "</div>, <div itemscope itemtype=\"http://schema.org/Book\"> \n" +
            " <!-- start schema.org - search engine optimization --> \n" +
            " <div class=\"recordColored\" id=\"record2\"> \n" +
            "  <div class=\"imageDiv\"> \n" +
            "   <img src=\"/doab?func=cover&amp;rid=22772\" width=\"110\" height=\"155\" border=\"0\"> \n" +
            "  </div>\n" +
            "  <!-- END imageDiv --> \n" +
            "  <div class=\"data\"> \n" +
            "   <b><span itemprop=\"name\">À ciel ouvert </span></b> \n" +
            "   <p> </p>\n" +
            "   <div style=\"color: #585858\"> \n" +
            "    <!-- author (s) --> \n" +
            "    <strong>Authors</strong>: \n" +
            "    <a itemprop=\"author\" href=\"/doab?func=search&amp;query=au:&quot;Ariela Epstein&quot;&amp;uiLanguage=en\">Ariela Epstein</a> \n" +
            "    <br> \n" +
            "    <!-- End Loop_au if--> \n" +
            "    <strong>ISBN</strong>: \n" +
            "    <span itemprop=\"isbn\">9782753536050 9782753552715</span> \n" +
            "    <strong>Year</strong>: \n" +
            "    <span itemprop=\"datePublished\">2015</span> \n" +
            "    <strong>Language</strong>: French \n" +
            "    <br>\n" +
            "    <strong>Publisher</strong>: \n" +
            "    <a itemprop=\"publisher\" href=\"/doab?func=publisher&amp;pId=1430&amp;uiLanguage=\">Presses universitaires de Rennes</a> \n" +
            "    <br>\n" +
            "    <strong>Added to DOAB on </strong>: 2017-07-04 12:22:54 \n" +
            "    <br>License: \n" +
            "    <a href=\"http://www.openedition.org/6540?lang=en\" target=\"blank\">OpenEdition licence for Books</a> \n" +
            "   </div>\n" +
            "   <!-- End color #585858 --> \n" +
            "   <p> </p>\n" +
            "   <div class=\"recordLinks\" id=\"r2\"> \n" +
            "    <h1> <a href=\"javascript:void(0)\" title=\"abs2\"> <span id=\"absLabel2\">Abstract</span> </a> | <a href=\"javascript:void(0)\" title=\"kw2\"> <span id=\"kwLabel2\">Keywords</span> </a> | <a itemprop=\"url\" href=\"/doab?func=fulltext&amp;uiLanguage=en&amp;rid=22772\" target=\"_blank\">Free access</a> | <a href=\"/doab?func=checkAvailability&amp;uiLanguage=en&amp;rid=22772\" class=\"checkAvailable\" title=\"av2\">Buy the book</a> | <a href=\"javascript:void(0)\" title=\"exp2\"> <span id=\"expLabel2\">Export citation</span></a> | <a class=\"addthis_button\" href=\"http://www.addthis.com/bookmark.php?v=300\" addthis:url=\"http://www.doabooks.org/doab?func=search&amp;query=rid:22772\" addthis:title=\"DOAB: À ciel ouvert\"><img style=\"border:0\" alt=\"Share\" src=\"/doabImages/addThis.gif\"> </a> </h1> \n" +
            "   </div> \n" +
            "   <!-- END recordLinks --> \n" +
            "   <div class=\"linkContent\"> \n" +
            "    <div id=\"av2\" class=\"tip dyn\">\n" +
            "     <img src=\"/doabImages/spinner.gif\"> Loading...\n" +
            "    </div> \n" +
            "    <div id=\"exp2\" class=\"tip\"> \n" +
            "     <b>Export citation</b> \n" +
            "     <p> Choose an application </p>\n" +
            "     <ul> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=referenceManager&amp;query=22772\"> Reference Manager</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=endNote&amp;query=22772\"> EndNote</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=refworks&amp;query=22772\" target=\"RefWorksMain\"> RefWorks</a> (Direct export to RefWorks)</li> \n" +
            "     </ul> \n" +
            "    </div> \n" +
            "    <div itemprop=\"description\" id=\"abs2\" class=\"tip\"> \n" +
            "     <b>Abstract</b>\n" +
            "     <p> L’ouvrage propose un parcours centré sur les murs de Montevideo (Uruguay), un regard ethnologique et sémiologique sur différents genres d’inscriptions et leur pratique : les pintadas des brigades de partis politiques ; les graffitis, murales, pochoirs et autres formes de street art de la jeune génération. Directement ou indirectement politiques, ces expressions graphiques sont le reflet de différentes manières de s’engager. Elles sont issues d’une tradition structurée, instituée comme un rite... </p>\n" +
            "    </div> \n" +
            "    <div id=\"kw2\" class=\"tip\"> \n" +
            "     <b>Keywords</b>\n" +
            "     <p> \n" +
            "      <!-- Multi --> <a itemprop=\"keywords\" href=\"/doab?func=search&amp;uiLanguage=en&amp;query=kw:&quot;art, Uruguay, Montevideo, graffiti, culture, culture urbaine, slogans politiques, anthropologie&quot;\">art, Uruguay, Montevideo, graffiti, culture, culture urbaine, slogans politiques, anthropologie</a> </p>\n" +
            "    </div> \n" +
            "   </div> \n" +
            "   <!-- END linkContent --> \n" +
            "  </div> \n" +
            "  <!-- END data --> \n" +
            "  <div style=\"clear:both\"></div> \n" +
            " </div> \n" +
            " <!-- END record ---> \n" +
            "</div>, <div itemscope itemtype=\"http://schema.org/Book\"> \n" +
            " <!-- start schema.org - search engine optimization --> \n" +
            " <div class=\"record\" id=\"record3\"> \n" +
            "  <div class=\"imageDiv\"> \n" +
            "   <img src=\"/doab?func=cover&amp;rid=24612\" width=\"110\" height=\"155\" border=\"0\"> \n" +
            "  </div>\n" +
            "  <!-- END imageDiv --> \n" +
            "  <div class=\"data\"> \n" +
            "   <b><span itemprop=\"name\">À droite de la droite </span></b> \n" +
            "   <p> </p>\n" +
            "   <div style=\"color: #585858\"> \n" +
            "    <!-- author (s) --> \n" +
            "    <strong>Authors</strong>: \n" +
            "    <a itemprop=\"author\" href=\"/doab?func=search&amp;query=au:&quot;Philippe Vervaecke (dir.)&quot;&amp;uiLanguage=en\">Philippe Vervaecke (dir.)</a> \n" +
            "    <br> \n" +
            "    <!-- End Loop_au if--> \n" +
            "    <strong>ISBN</strong>: \n" +
            "    <span itemprop=\"isbn\">9782757403693 9782757418536</span> \n" +
            "    <strong>Year</strong>: \n" +
            "    <span itemprop=\"datePublished\">2012</span> \n" +
            "    <strong>Language</strong>: French \n" +
            "    <br>\n" +
            "    <strong>Publisher</strong>: \n" +
            "    <a itemprop=\"publisher\" href=\"/doab?func=publisher&amp;pId=1424&amp;uiLanguage=\">Presses universitaires du Septentrion</a> \n" +
            "    <br>\n" +
            "    <strong>Added to DOAB on </strong>: 2017-11-23 16:07:54 \n" +
            "    <br>License: \n" +
            "    <a href=\"http://www.openedition.org/6540?lang=en\" target=\"blank\">OpenEdition licence for Books</a> \n" +
            "   </div>\n" +
            "   <!-- End color #585858 --> \n" +
            "   <p> </p>\n" +
            "   <div class=\"recordLinks\" id=\"r3\"> \n" +
            "    <h1> <a href=\"javascript:void(0)\" title=\"abs3\"> <span id=\"absLabel3\">Abstract</span> </a> | <a href=\"javascript:void(0)\" title=\"kw3\"> <span id=\"kwLabel3\">Keywords</span> </a> | <a itemprop=\"url\" href=\"/doab?func=fulltext&amp;uiLanguage=en&amp;rid=24612\" target=\"_blank\">Free access</a> | <a href=\"/doab?func=checkAvailability&amp;uiLanguage=en&amp;rid=24612\" class=\"checkAvailable\" title=\"av3\">Buy the book</a> | <a href=\"javascript:void(0)\" title=\"exp3\"> <span id=\"expLabel3\">Export citation</span></a> | <a class=\"addthis_button\" href=\"http://www.addthis.com/bookmark.php?v=300\" addthis:url=\"http://www.doabooks.org/doab?func=search&amp;query=rid:24612\" addthis:title=\"DOAB: À droite de la droite\"><img style=\"border:0\" alt=\"Share\" src=\"/doabImages/addThis.gif\"> </a> </h1> \n" +
            "   </div> \n" +
            "   <!-- END recordLinks --> \n" +
            "   <div class=\"linkContent\"> \n" +
            "    <div id=\"av3\" class=\"tip dyn\">\n" +
            "     <img src=\"/doabImages/spinner.gif\"> Loading...\n" +
            "    </div> \n" +
            "    <div id=\"exp3\" class=\"tip\"> \n" +
            "     <b>Export citation</b> \n" +
            "     <p> Choose an application </p>\n" +
            "     <ul> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=referenceManager&amp;query=24612\"> Reference Manager</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=endNote&amp;query=24612\"> EndNote</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=refworks&amp;query=24612\" target=\"RefWorksMain\"> RefWorks</a> (Direct export to RefWorks)</li> \n" +
            "     </ul> \n" +
            "    </div> \n" +
            "    <div itemprop=\"description\" id=\"abs3\" class=\"tip\"> \n" +
            "     <b>Abstract</b>\n" +
            "     <p> Bastions de la démocratie libérale en Europe au début du xxe siècle, la France et la Grande- Bretagne ont été affectés par le processus de radicalisation des droites à divers moments de leur histoire respective. Ligues patriotiques du début du siècle, partis fascistes ou fascisants de l’entre-deux-guerres et extrêmes droites xénophobes et nationalistes d’après 1945 ont successivement contribué à affirmer l’existence d’une droite de la droite dans les deux pays. L’ouvrage pose la question des... </p>\n" +
            "    </div> \n" +
            "    <div id=\"kw3\" class=\"tip\"> \n" +
            "     <b>Keywords</b>\n" +
            "     <p> \n" +
            "      <!-- Multi --> <a itemprop=\"keywords\" href=\"/doab?func=search&amp;uiLanguage=en&amp;query=kw:&quot;culture politique, fascisme, militantisme, droite, idéologies politiques&quot;\">culture politique, fascisme, militantisme, droite, idéologies politiques</a> </p>\n" +
            "    </div> \n" +
            "   </div> \n" +
            "   <!-- END linkContent --> \n" +
            "  </div> \n" +
            "  <!-- END data --> \n" +
            "  <div style=\"clear:both\"></div> \n" +
            " </div> \n" +
            " <!-- END record ---> \n" +
            "</div>, <div itemscope itemtype=\"http://schema.org/Book\"> \n" +
            " <!-- start schema.org - search engine optimization --> \n" +
            " <div class=\"recordColored\" id=\"record4\"> \n" +
            "  <div class=\"imageDiv\"> \n" +
            "   <img src=\"/doab?func=cover&amp;rid=22764\" width=\"110\" height=\"155\" border=\"0\"> \n" +
            "  </div>\n" +
            "  <!-- END imageDiv --> \n" +
            "  <div class=\"data\"> \n" +
            "   <b><span itemprop=\"name\">À la croisée des pouvoirs </span></b> \n" +
            "   <p> </p>\n" +
            "   <div style=\"color: #585858\"> \n" +
            "    <!-- author (s) --> \n" +
            "    <strong>Authors</strong>: \n" +
            "    <a itemprop=\"author\" href=\"/doab?func=search&amp;query=au:&quot;Pierre-Marie Bosc&quot;&amp;uiLanguage=en\">Pierre-Marie Bosc</a> \n" +
            "    <br> \n" +
            "    <!-- End Loop_au if--> \n" +
            "    <strong>ISBN</strong>: \n" +
            "    <span itemprop=\"isbn\">9782709915625 9782709922982</span> \n" +
            "    <strong>Year</strong>: \n" +
            "    <span itemprop=\"datePublished\">2005</span> \n" +
            "    <strong>Language</strong>: French \n" +
            "    <br>\n" +
            "    <strong>Publisher</strong>: \n" +
            "    <a itemprop=\"publisher\" href=\"/doab?func=publisher&amp;pId=1470&amp;uiLanguage=\">IRD Éditions</a> \n" +
            "    <br>\n" +
            "    <strong>Added to DOAB on </strong>: 2017-07-04 12:05:58 \n" +
            "    <br>License: \n" +
            "    <a href=\"http://www.openedition.org/6540?lang=en\" target=\"blank\">OpenEdition licence for Books</a> \n" +
            "   </div>\n" +
            "   <!-- End color #585858 --> \n" +
            "   <p> </p>\n" +
            "   <div class=\"recordLinks\" id=\"r4\"> \n" +
            "    <h1> <a href=\"javascript:void(0)\" title=\"abs4\"> <span id=\"absLabel4\">Abstract</span> </a> | <a href=\"javascript:void(0)\" title=\"kw4\"> <span id=\"kwLabel4\">Keywords</span> </a> | <a itemprop=\"url\" href=\"/doab?func=fulltext&amp;uiLanguage=en&amp;rid=22764\" target=\"_blank\">Free access</a> | <a href=\"/doab?func=checkAvailability&amp;uiLanguage=en&amp;rid=22764\" class=\"checkAvailable\" title=\"av4\">Buy the book</a> | <a href=\"javascript:void(0)\" title=\"exp4\"> <span id=\"expLabel4\">Export citation</span></a> | <a class=\"addthis_button\" href=\"http://www.addthis.com/bookmark.php?v=300\" addthis:url=\"http://www.doabooks.org/doab?func=search&amp;query=rid:22764\" addthis:title=\"DOAB: À la croisée des pouvoirs\"><img style=\"border:0\" alt=\"Share\" src=\"/doabImages/addThis.gif\"> </a> </h1> \n" +
            "   </div> \n" +
            "   <!-- END recordLinks --> \n" +
            "   <div class=\"linkContent\"> \n" +
            "    <div id=\"av4\" class=\"tip dyn\">\n" +
            "     <img src=\"/doabImages/spinner.gif\"> Loading...\n" +
            "    </div> \n" +
            "    <div id=\"exp4\" class=\"tip\"> \n" +
            "     <b>Export citation</b> \n" +
            "     <p> Choose an application </p>\n" +
            "     <ul> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=referenceManager&amp;query=22764\"> Reference Manager</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=endNote&amp;query=22764\"> EndNote</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=refworks&amp;query=22764\" target=\"RefWorksMain\"> RefWorks</a> (Direct export to RefWorks)</li> \n" +
            "     </ul> \n" +
            "    </div> \n" +
            "    <div itemprop=\"description\" id=\"abs4\" class=\"tip\"> \n" +
            "     <b>Abstract</b>\n" +
            "     <p> C'est à partir de 1992, après la Conférence de Rio, que le développement durable devient un objectif central des politiques publiques. Pourtant, dès les années 1980 en Basse Casamance, une organisation paysanne se préoccupe de rechercher des solutions à la grave crise écologique et de subsistance qui ébranle les systèmes de production. Son positionnement en faveur d'une gestion durable des ressources naturelles tranche avec les choix habituels des associations. Cet ouvrage présente une étude... </p>\n" +
            "    </div> \n" +
            "    <div id=\"kw4\" class=\"tip\"> \n" +
            "     <b>Keywords</b>\n" +
            "     <p> \n" +
            "      <!-- Multi --> <a itemprop=\"keywords\" href=\"/doab?func=search&amp;uiLanguage=en&amp;query=kw:&quot;gestion de l’environnement, Gestion durable, ressources, riziculture, développement rural, Sénégal&quot;\">gestion de l’environnement, Gestion durable, ressources, riziculture, développement rural, Sénégal</a> </p>\n" +
            "    </div> \n" +
            "   </div> \n" +
            "   <!-- END linkContent --> \n" +
            "  </div> \n" +
            "  <!-- END data --> \n" +
            "  <div style=\"clear:both\"></div> \n" +
            " </div> \n" +
            " <!-- END record ---> \n" +
            "</div>, <div itemscope itemtype=\"http://schema.org/Book\"> \n" +
            " <!-- start schema.org - search engine optimization --> \n" +
            " <div class=\"record\" id=\"record5\"> \n" +
            "  <div class=\"imageDiv\"> \n" +
            "   <img src=\"/doab?func=cover&amp;rid=22336\" width=\"110\" height=\"155\" border=\"0\"> \n" +
            "  </div>\n" +
            "  <!-- END imageDiv --> \n" +
            "  <div class=\"data\"> \n" +
            "   <b><span itemprop=\"name\">À la découverte des villages de métier au Vietnam </span></b> \n" +
            "   <p> </p>\n" +
            "   <div style=\"color: #585858\"> \n" +
            "    <!-- author (s) --> \n" +
            "    <strong>Authors</strong>: \n" +
            "    <a itemprop=\"author\" href=\"/doab?func=search&amp;query=au:&quot;Sylvie Fanchette, Nicholas Stedman&quot;&amp;uiLanguage=en\">Sylvie Fanchette, Nicholas Stedman</a> \n" +
            "    <br> \n" +
            "    <!-- End Loop_au if--> \n" +
            "    <strong>ISBN</strong>: \n" +
            "    <span itemprop=\"isbn\">9782709916707 9782709918497</span> \n" +
            "    <strong>Year</strong>: \n" +
            "    <span itemprop=\"datePublished\">2009</span> \n" +
            "    <strong>Language</strong>: French \n" +
            "    <br>\n" +
            "    <strong>Publisher</strong>: \n" +
            "    <a itemprop=\"publisher\" href=\"/doab?func=publisher&amp;pId=1470&amp;uiLanguage=\">IRD Éditions</a> \n" +
            "    <br>\n" +
            "    <strong>Added to DOAB on </strong>: 2017-06-09 10:17:46 \n" +
            "    <br>License: \n" +
            "    <a href=\"http://www.openedition.org/6540?lang=en\" target=\"blank\">OpenEdition licence for Books</a> \n" +
            "   </div>\n" +
            "   <!-- End color #585858 --> \n" +
            "   <p> </p>\n" +
            "   <div class=\"recordLinks\" id=\"r5\"> \n" +
            "    <h1> <a href=\"javascript:void(0)\" title=\"abs5\"> <span id=\"absLabel5\">Abstract</span> </a> | <a href=\"javascript:void(0)\" title=\"kw5\"> <span id=\"kwLabel5\">Keywords</span> </a> | <a itemprop=\"url\" href=\"/doab?func=fulltext&amp;uiLanguage=en&amp;rid=22336\" target=\"_blank\">Free access</a> | <a href=\"/doab?func=checkAvailability&amp;uiLanguage=en&amp;rid=22336\" class=\"checkAvailable\" title=\"av5\">Buy the book</a> | <a href=\"javascript:void(0)\" title=\"exp5\"> <span id=\"expLabel5\">Export citation</span></a> | <a class=\"addthis_button\" href=\"http://www.addthis.com/bookmark.php?v=300\" addthis:url=\"http://www.doabooks.org/doab?func=search&amp;query=rid:22336\" addthis:title=\"DOAB: À la découverte des villages de métier au Vietnam\"><img style=\"border:0\" alt=\"Share\" src=\"/doabImages/addThis.gif\"> </a> </h1> \n" +
            "   </div> \n" +
            "   <!-- END recordLinks --> \n" +
            "   <div class=\"linkContent\"> \n" +
            "    <div id=\"av5\" class=\"tip dyn\">\n" +
            "     <img src=\"/doabImages/spinner.gif\"> Loading...\n" +
            "    </div> \n" +
            "    <div id=\"exp5\" class=\"tip\"> \n" +
            "     <b>Export citation</b> \n" +
            "     <p> Choose an application </p>\n" +
            "     <ul> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=referenceManager&amp;query=22336\"> Reference Manager</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=endNote&amp;query=22336\"> EndNote</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=refworks&amp;query=22336\" target=\"RefWorksMain\"> RefWorks</a> (Direct export to RefWorks)</li> \n" +
            "     </ul> \n" +
            "    </div> \n" +
            "    <div itemprop=\"description\" id=\"abs5\" class=\"tip\"> \n" +
            "     <b>Abstract</b>\n" +
            "     <p> Les villages des alentours de Hà Noi révèlent un riche patrimoine culturel, technique et architectural. Plus de 500 villages de métier spécialisés dans la fabrication d'objets d'art et de culte, de produits agro-alimentaires, industriels, textiles ou de vanneries sont accessibles à moins d'une heure de la capitale. Ce patrimoine a été préservé, malgré les dures périodes de l'histoire vietnamienne, et constitue la base culturelle matérielle et immatérielle de la société villageoise du delta d... </p>\n" +
            "    </div> \n" +
            "    <div id=\"kw5\" class=\"tip\"> \n" +
            "     <b>Keywords</b>\n" +
            "     <p> \n" +
            "      <!-- Multi --> <a itemprop=\"keywords\" href=\"/doab?func=search&amp;uiLanguage=en&amp;query=kw:&quot;village, industrialisation, activité sectorielle, secteur informel, division du travail, pollution des eaux continentales, concurrence, Vietnam&quot;\">village, industrialisation, activité sectorielle, secteur informel, division du travail, pollution des eaux continentales, concurrence, Vietnam</a> </p>\n" +
            "    </div> \n" +
            "   </div> \n" +
            "   <!-- END linkContent --> \n" +
            "  </div> \n" +
            "  <!-- END data --> \n" +
            "  <div style=\"clear:both\"></div> \n" +
            " </div> \n" +
            " <!-- END record ---> \n" +
            "</div>, <div itemscope itemtype=\"http://schema.org/Book\"> \n" +
            " <!-- start schema.org - search engine optimization --> \n" +
            " <div class=\"recordColored\" id=\"record6\"> \n" +
            "  <div class=\"imageDiv\"> \n" +
            "   <img src=\"/doab?func=cover&amp;rid=24623\" width=\"110\" height=\"155\" border=\"0\"> \n" +
            "  </div>\n" +
            "  <!-- END imageDiv --> \n" +
            "  <div class=\"data\"> \n" +
            "   <b><span itemprop=\"name\">À la place du roi </span></b> \n" +
            "   <p> </p>\n" +
            "   <div style=\"color: #585858\"> \n" +
            "    <!-- author (s) --> \n" +
            "    <strong>Authors</strong>: \n" +
            "    <a itemprop=\"author\" href=\"/doab?func=search&amp;query=au:&quot;Daniel Aznar, Guillaume Hanotin, Niels F. May (dir.)&quot;&amp;uiLanguage=en\">Daniel Aznar, Guillaume Hanotin, Niels F. May (dir.)</a> \n" +
            "    <br> \n" +
            "    <!-- End Loop_au if--> \n" +
            "    <strong>ISBN</strong>: \n" +
            "    <span itemprop=\"isbn\">9788415636854 9788490961469</span> \n" +
            "    <strong>Year</strong>: \n" +
            "    <span itemprop=\"datePublished\">2015</span> \n" +
            "    <strong>Language</strong>: French \n" +
            "    <br>\n" +
            "    <strong>Publisher</strong>: \n" +
            "    <a itemprop=\"publisher\" href=\"/doab?func=publisher&amp;pId=1464&amp;uiLanguage=\">Casa de Velázquez</a> \n" +
            "    <br>\n" +
            "    <strong>Added to DOAB on </strong>: 2017-11-23 16:14:13 \n" +
            "    <br>License: \n" +
            "    <a href=\"http://www.openedition.org/6540?lang=en\" target=\"blank\">OpenEdition licence for Books</a> \n" +
            "   </div>\n" +
            "   <!-- End color #585858 --> \n" +
            "   <p> </p>\n" +
            "   <div class=\"recordLinks\" id=\"r6\"> \n" +
            "    <h1> <a href=\"javascript:void(0)\" title=\"abs6\"> <span id=\"absLabel6\">Abstract</span> </a> | <a href=\"javascript:void(0)\" title=\"kw6\"> <span id=\"kwLabel6\">Keywords</span> </a> | <a itemprop=\"url\" href=\"/doab?func=fulltext&amp;uiLanguage=en&amp;rid=24623\" target=\"_blank\">Free access</a> | <a href=\"/doab?func=checkAvailability&amp;uiLanguage=en&amp;rid=24623\" class=\"checkAvailable\" title=\"av6\">Buy the book</a> | <a href=\"javascript:void(0)\" title=\"exp6\"> <span id=\"expLabel6\">Export citation</span></a> | <a class=\"addthis_button\" href=\"http://www.addthis.com/bookmark.php?v=300\" addthis:url=\"http://www.doabooks.org/doab?func=search&amp;query=rid:24623\" addthis:title=\"DOAB: À la place du roi\"><img style=\"border:0\" alt=\"Share\" src=\"/doabImages/addThis.gif\"> </a> </h1> \n" +
            "   </div> \n" +
            "   <!-- END recordLinks --> \n" +
            "   <div class=\"linkContent\"> \n" +
            "    <div id=\"av6\" class=\"tip dyn\">\n" +
            "     <img src=\"/doabImages/spinner.gif\"> Loading...\n" +
            "    </div> \n" +
            "    <div id=\"exp6\" class=\"tip\"> \n" +
            "     <b>Export citation</b> \n" +
            "     <p> Choose an application </p>\n" +
            "     <ul> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=referenceManager&amp;query=24623\"> Reference Manager</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=endNote&amp;query=24623\"> EndNote</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=refworks&amp;query=24623\" target=\"RefWorksMain\"> RefWorks</a> (Direct export to RefWorks)</li> \n" +
            "     </ul> \n" +
            "    </div> \n" +
            "    <div itemprop=\"description\" id=\"abs6\" class=\"tip\"> \n" +
            "     <b>Abstract</b>\n" +
            "     <p> À l'aube des temps modernes, les monarchies espagnole et française se profilent comme les deux plus puissantes d'Europe occidentale. Rivales, elles sont néanmoins liées par d'innombrables liens, politiques et culturels. La volonté de s'affirmer, tant à l'intérieur qu'à l'extérieur de leurs états, impose à leurs princes de s'appuyer sur des individus capables de rendre visible, voire présente, leur autorité et leur dignité. Les vice-rois hispaniques, comme les gouverneurs français, ont alors p... </p>\n" +
            "    </div> \n" +
            "    <div id=\"kw6\" class=\"tip\"> \n" +
            "     <b>Keywords</b>\n" +
            "     <p> \n" +
            "      <!-- Multi --> <a itemprop=\"keywords\" href=\"/doab?func=search&amp;uiLanguage=en&amp;query=kw:&quot;monarchie, France, pouvoir, roi, Espagne&quot;\">monarchie, France, pouvoir, roi, Espagne</a> </p>\n" +
            "    </div> \n" +
            "   </div> \n" +
            "   <!-- END linkContent --> \n" +
            "  </div> \n" +
            "  <!-- END data --> \n" +
            "  <div style=\"clear:both\"></div> \n" +
            " </div> \n" +
            " <!-- END record ---> \n" +
            "</div>, <div itemscope itemtype=\"http://schema.org/Book\"> \n" +
            " <!-- start schema.org - search engine optimization --> \n" +
            " <div class=\"record\" id=\"record7\"> \n" +
            "  <div class=\"imageDiv\"> \n" +
            "   <img src=\"/doab?func=cover&amp;rid=22107\" width=\"110\" height=\"155\" border=\"0\"> \n" +
            "  </div>\n" +
            "  <!-- END imageDiv --> \n" +
            "  <div class=\"data\"> \n" +
            "   <b><span itemprop=\"name\">À la recherche de l'effectivité des droits de l'homme </span></b> \n" +
            "   <p> </p>\n" +
            "   <div style=\"color: #585858\"> \n" +
            "    <!-- author (s) --> \n" +
            "    <strong>Authors</strong>: \n" +
            "    <a itemprop=\"author\" href=\"/doab?func=search&amp;query=au:&quot;Véronique Champeil-Desplats, Danièle Lochak (dir.)&quot;&amp;uiLanguage=en\">Véronique Champeil-Desplats, Danièle Lochak (dir.)</a> \n" +
            "    <br> \n" +
            "    <!-- End Loop_au if--> \n" +
            "    <strong>ISBN</strong>: \n" +
            "    <span itemprop=\"isbn\">9782840160236 9782821826700</span> \n" +
            "    <strong>Year</strong>: \n" +
            "    <span itemprop=\"datePublished\">2008</span> \n" +
            "    <strong>Language</strong>: French \n" +
            "    <br>\n" +
            "    <strong>Publisher</strong>: \n" +
            "    <a itemprop=\"publisher\" href=\"/doab?func=publisher&amp;pId=1462&amp;uiLanguage=\">Presses universitaires de Paris Nanterre</a> \n" +
            "    <br>\n" +
            "    <strong>Added to DOAB on </strong>: 2017-05-29 10:33:34 \n" +
            "    <br>License: \n" +
            "    <a href=\"http://www.openedition.org/6540?lang=en\" target=\"blank\">OpenEdition licence for Books</a> \n" +
            "   </div>\n" +
            "   <!-- End color #585858 --> \n" +
            "   <p> </p>\n" +
            "   <div class=\"recordLinks\" id=\"r7\"> \n" +
            "    <h1> <a href=\"javascript:void(0)\" title=\"abs7\"> <span id=\"absLabel7\">Abstract</span> </a> | <a href=\"javascript:void(0)\" title=\"kw7\"> <span id=\"kwLabel7\">Keywords</span> </a> | <a itemprop=\"url\" href=\"/doab?func=fulltext&amp;uiLanguage=en&amp;rid=22107\" target=\"_blank\">Free access</a> | <a href=\"/doab?func=checkAvailability&amp;uiLanguage=en&amp;rid=22107\" class=\"checkAvailable\" title=\"av7\">Buy the book</a> | <a href=\"javascript:void(0)\" title=\"exp7\"> <span id=\"expLabel7\">Export citation</span></a> | <a class=\"addthis_button\" href=\"http://www.addthis.com/bookmark.php?v=300\" addthis:url=\"http://www.doabooks.org/doab?func=search&amp;query=rid:22107\" addthis:title=\"DOAB: À la recherche de l'effectivité des droits de l'homme\"><img style=\"border:0\" alt=\"Share\" src=\"/doabImages/addThis.gif\"> </a> </h1> \n" +
            "   </div> \n" +
            "   <!-- END recordLinks --> \n" +
            "   <div class=\"linkContent\"> \n" +
            "    <div id=\"av7\" class=\"tip dyn\">\n" +
            "     <img src=\"/doabImages/spinner.gif\"> Loading...\n" +
            "    </div> \n" +
            "    <div id=\"exp7\" class=\"tip\"> \n" +
            "     <b>Export citation</b> \n" +
            "     <p> Choose an application </p>\n" +
            "     <ul> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=referenceManager&amp;query=22107\"> Reference Manager</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=endNote&amp;query=22107\"> EndNote</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=refworks&amp;query=22107\" target=\"RefWorksMain\"> RefWorks</a> (Direct export to RefWorks)</li> \n" +
            "     </ul> \n" +
            "    </div> \n" +
            "    <div itemprop=\"description\" id=\"abs7\" class=\"tip\"> \n" +
            "     <b>Abstract</b>\n" +
            "     <p> Le champ des droits de l’homme est certainement l’un de ceux où l’écart entre l’existence de la norme et la réalité de son application est le plus grand, et dont les effets sont au quotidien les plus ressentis. On comprend alors que la question de l’effectivité soit au cœur des réflexions sur les droits de l’homme. Cette question comporte indéniablement une dimension théorique : comment distinguer les notions d’effectivité, d’efficacité ou de validité de la norme ? Comment penser le passage d... </p>\n" +
            "    </div> \n" +
            "    <div id=\"kw7\" class=\"tip\"> \n" +
            "     <b>Keywords</b>\n" +
            "     <p> \n" +
            "      <!-- Multi --> <a itemprop=\"keywords\" href=\"/doab?func=search&amp;uiLanguage=en&amp;query=kw:&quot;droits de l'homme, droit à la santé, Cour européenne des droits de l'homme, Loi IVG, discrimination raciale&quot;\">droits de l'homme, droit à la santé, Cour européenne des droits de l'homme, Loi IVG, discrimination raciale</a> </p>\n" +
            "    </div> \n" +
            "   </div> \n" +
            "   <!-- END linkContent --> \n" +
            "  </div> \n" +
            "  <!-- END data --> \n" +
            "  <div style=\"clear:both\"></div> \n" +
            " </div> \n" +
            " <!-- END record ---> \n" +
            "</div>, <div itemscope itemtype=\"http://schema.org/Book\"> \n" +
            " <!-- start schema.org - search engine optimization --> \n" +
            " <div class=\"recordColored\" id=\"record8\"> \n" +
            "  <div class=\"imageDiv\"> \n" +
            "   <img src=\"/doab?func=cover&amp;rid=23830\" width=\"110\" height=\"155\" border=\"0\"> \n" +
            "  </div>\n" +
            "  <!-- END imageDiv --> \n" +
            "  <div class=\"data\"> \n" +
            "   <b><span itemprop=\"name\">À la recherche de la Bosnie-Herzégovine </span></b> \n" +
            "   <p> </p>\n" +
            "   <div style=\"color: #585858\"> \n" +
            "    <!-- author (s) --> \n" +
            "    <strong>Authors</strong>: \n" +
            "    <a itemprop=\"author\" href=\"/doab?func=search&amp;query=au:&quot;Marianne Ducasse-Rogier&quot;&amp;uiLanguage=en\">Marianne Ducasse-Rogier</a> \n" +
            "    <br> \n" +
            "    <!-- End Loop_au if--> \n" +
            "    <strong>ISBN</strong>: \n" +
            "    <span itemprop=\"isbn\">9782130532873 9782940549184</span> \n" +
            "    <strong>Year</strong>: \n" +
            "    <span itemprop=\"datePublished\">2004</span> \n" +
            "    <strong>Language</strong>: French \n" +
            "    <br>\n" +
            "    <strong>Publisher</strong>: \n" +
            "    <a itemprop=\"publisher\" href=\"/doab?func=publisher&amp;pId=1502&amp;uiLanguage=\">Graduate Institute Publications</a> \n" +
            "    <br>\n" +
            "    <strong>Added to DOAB on </strong>: 2017-10-09 11:02:38 \n" +
            "    <br>License: \n" +
            "    <a href=\"https://creativecommons.org/licenses/by-nc-nd/3.0/legalcode\" target=\"blank\"><img src=\"https://i.creativecommons.org/l/by-nc-nd/3.0/80x15.png\"> </a> \n" +
            "   </div>\n" +
            "   <!-- End color #585858 --> \n" +
            "   <p> </p>\n" +
            "   <div class=\"recordLinks\" id=\"r8\"> \n" +
            "    <h1> <a href=\"javascript:void(0)\" title=\"abs8\"> <span id=\"absLabel8\">Abstract</span> </a> | <a href=\"javascript:void(0)\" title=\"kw8\"> <span id=\"kwLabel8\">Keywords</span> </a> | <a itemprop=\"url\" href=\"/doab?func=fulltext&amp;uiLanguage=en&amp;rid=23830\" target=\"_blank\">Free access</a> | <a href=\"/doab?func=checkAvailability&amp;uiLanguage=en&amp;rid=23830\" class=\"checkAvailable\" title=\"av8\">Buy the book</a> | <a href=\"javascript:void(0)\" title=\"exp8\"> <span id=\"expLabel8\">Export citation</span></a> | <a class=\"addthis_button\" href=\"http://www.addthis.com/bookmark.php?v=300\" addthis:url=\"http://www.doabooks.org/doab?func=search&amp;query=rid:23830\" addthis:title=\"DOAB: À la recherche de la Bosnie-Herzégovine\"><img style=\"border:0\" alt=\"Share\" src=\"/doabImages/addThis.gif\"> </a> </h1> \n" +
            "   </div> \n" +
            "   <!-- END recordLinks --> \n" +
            "   <div class=\"linkContent\"> \n" +
            "    <div id=\"av8\" class=\"tip dyn\">\n" +
            "     <img src=\"/doabImages/spinner.gif\"> Loading...\n" +
            "    </div> \n" +
            "    <div id=\"exp8\" class=\"tip\"> \n" +
            "     <b>Export citation</b> \n" +
            "     <p> Choose an application </p>\n" +
            "     <ul> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=referenceManager&amp;query=23830\"> Reference Manager</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=endNote&amp;query=23830\"> EndNote</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=refworks&amp;query=23830\" target=\"RefWorksMain\"> RefWorks</a> (Direct export to RefWorks)</li> \n" +
            "     </ul> \n" +
            "    </div> \n" +
            "    <div itemprop=\"description\" id=\"abs8\" class=\"tip\"> \n" +
            "     <b>Abstract</b>\n" +
            "     <p> L’ouvrage de Marianne Ducasse-Rogier analyse en profondeur et dans sa globalité la gigantesque entreprise de reconstruction de la Bosnie-Herzégovine qu’a constitué la mise en œuvre de l’accord de paix de Dayton signé en novembre 1995. Cette étude pluridisciplinaire et critique aborde tous les aspects de l’opération originale de consolidation de la paix entreprise à cette occasion. Elle traite en particulier des questions de sécurité (extérieure et intérieure) et, sur le plan civil, de la démo... </p>\n" +
            "    </div> \n" +
            "    <div id=\"kw8\" class=\"tip\"> \n" +
            "     <b>Keywords</b>\n" +
            "     <p> \n" +
            "      <!-- Multi --> <a itemprop=\"keywords\" href=\"/doab?func=search&amp;uiLanguage=en&amp;query=kw:&quot;guerre, conflits  sécurité et consolidation de la paix, reconstruction, crimes &amp;&quot;\">guerre, conflits sécurité et consolidation de la paix, reconstruction, crimes &amp;</a> --- <a itemprop=\"keywords\" href=\"/doab?func=search&amp;uiLanguage=en&amp;query=kw:&quot;violence, accord de Dayton, sécurité, protection des populations civiles&quot;\">violence, accord de Dayton, sécurité, protection des populations civiles</a> </p>\n" +
            "    </div> \n" +
            "   </div> \n" +
            "   <!-- END linkContent --> \n" +
            "  </div> \n" +
            "  <!-- END data --> \n" +
            "  <div style=\"clear:both\"></div> \n" +
            " </div> \n" +
            " <!-- END record ---> \n" +
            "</div>, <div itemscope itemtype=\"http://schema.org/Book\"> \n" +
            " <!-- start schema.org - search engine optimization --> \n" +
            " <div class=\"record\" id=\"record9\"> \n" +
            "  <div class=\"imageDiv\"> \n" +
            "   <img src=\"/doab?func=cover&amp;rid=22108\" width=\"110\" height=\"155\" border=\"0\"> \n" +
            "  </div>\n" +
            "  <!-- END imageDiv --> \n" +
            "  <div class=\"data\"> \n" +
            "   <b><span itemprop=\"name\">À la recherche du rameau d'or </span></b> \n" +
            "   <p> </p>\n" +
            "   <div style=\"color: #585858\"> \n" +
            "    <!-- author (s) --> \n" +
            "    <strong>Authors</strong>: \n" +
            "    <a itemprop=\"author\" href=\"/doab?func=search&amp;query=au:&quot;Marianne Cojannot-Le Blanc&quot;&amp;uiLanguage=en\">Marianne Cojannot-Le Blanc</a> \n" +
            "    <br> \n" +
            "    <!-- End Loop_au if--> \n" +
            "    <strong>ISBN</strong>: \n" +
            "    <span itemprop=\"isbn\">9782840161073 9782821851146</span> \n" +
            "    <strong>Year</strong>: \n" +
            "    <span itemprop=\"datePublished\">2012</span> \n" +
            "    <strong>Language</strong>: French \n" +
            "    <br>\n" +
            "    <strong>Publisher</strong>: \n" +
            "    <a itemprop=\"publisher\" href=\"/doab?func=publisher&amp;pId=1462&amp;uiLanguage=\">Presses universitaires de Paris Nanterre</a> \n" +
            "    <br>\n" +
            "    <strong>Added to DOAB on </strong>: 2017-05-29 10:33:34 \n" +
            "    <br>License: \n" +
            "    <a href=\"http://www.openedition.org/6540?lang=en\" target=\"blank\">OpenEdition licence for Books</a> \n" +
            "   </div>\n" +
            "   <!-- End color #585858 --> \n" +
            "   <p> </p>\n" +
            "   <div class=\"recordLinks\" id=\"r9\"> \n" +
            "    <h1> <a href=\"javascript:void(0)\" title=\"abs9\"> <span id=\"absLabel9\">Abstract</span> </a> | <a href=\"javascript:void(0)\" title=\"kw9\"> <span id=\"kwLabel9\">Keywords</span> </a> | <a itemprop=\"url\" href=\"/doab?func=fulltext&amp;uiLanguage=en&amp;rid=22108\" target=\"_blank\">Free access</a> | <a href=\"/doab?func=checkAvailability&amp;uiLanguage=en&amp;rid=22108\" class=\"checkAvailable\" title=\"av9\">Buy the book</a> | <a href=\"javascript:void(0)\" title=\"exp9\"> <span id=\"expLabel9\">Export citation</span></a> | <a class=\"addthis_button\" href=\"http://www.addthis.com/bookmark.php?v=300\" addthis:url=\"http://www.doabooks.org/doab?func=search&amp;query=rid:22108\" addthis:title=\"DOAB: À la recherche du rameau d'or\"><img style=\"border:0\" alt=\"Share\" src=\"/doabImages/addThis.gif\"> </a> </h1> \n" +
            "   </div> \n" +
            "   <!-- END recordLinks --> \n" +
            "   <div class=\"linkContent\"> \n" +
            "    <div id=\"av9\" class=\"tip dyn\">\n" +
            "     <img src=\"/doabImages/spinner.gif\"> Loading...\n" +
            "    </div> \n" +
            "    <div id=\"exp9\" class=\"tip\"> \n" +
            "     <b>Export citation</b> \n" +
            "     <p> Choose an application </p>\n" +
            "     <ul> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=referenceManager&amp;query=22108\"> Reference Manager</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=endNote&amp;query=22108\"> EndNote</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=refworks&amp;query=22108\" target=\"RefWorksMain\"> RefWorks</a> (Direct export to RefWorks)</li> \n" +
            "     </ul> \n" +
            "    </div> \n" +
            "    <div itemprop=\"description\" id=\"abs9\" class=\"tip\"> \n" +
            "     <b>Abstract</b>\n" +
            "     <p> Au printemps 1650, le tableau du Ravissement de saint Paul de Nicolas Poussin (musée du Louvre) quittait Rome pour Paris. Il avait fallu cinq ans pour que le peintre finisse par satisfaire la demande du poète Paul Scarron. Vingt ans après, le même tableau était extrait des collections de Louis xiv pour être commenté deux fois au sein de l'Académie royale de peinture et de sculpture. Les deux conférences, dont l'une de Charles Le Brun, soulignaient les exceptionnelles qualités formelles de l' ... </p>\n" +
            "    </div> \n" +
            "    <div id=\"kw9\" class=\"tip\"> \n" +
            "     <b>Keywords</b>\n" +
            "     <p> \n" +
            "      <!-- Multi --> <a itemprop=\"keywords\" href=\"/doab?func=search&amp;uiLanguage=en&amp;query=kw:&quot;Nicolas Poussin, Ravissement de saint Paul, christianisme, saint, art, Histoire de l'art&quot;\">Nicolas Poussin, Ravissement de saint Paul, christianisme, saint, art, Histoire de l'art</a> </p>\n" +
            "    </div> \n" +
            "   </div> \n" +
            "   <!-- END linkContent --> \n" +
            "  </div> \n" +
            "  <!-- END data --> \n" +
            "  <div style=\"clear:both\"></div> \n" +
            " </div> \n" +
            " <!-- END record ---> \n" +
            "</div>, <div itemscope itemtype=\"http://schema.org/Book\"> \n" +
            " <!-- start schema.org - search engine optimization --> \n" +
            " <div class=\"recordColored\" id=\"record10\"> \n" +
            "  <div class=\"imageDiv\"> \n" +
            "   <img src=\"/doab?func=cover&amp;rid=22109\" width=\"110\" height=\"155\" border=\"0\"> \n" +
            "  </div>\n" +
            "  <!-- END imageDiv --> \n" +
            "  <div class=\"data\"> \n" +
            "   <b><span itemprop=\"name\">À la rencontre... </span></b> \n" +
            "   <p> </p>\n" +
            "   <div style=\"color: #585858\"> \n" +
            "    <!-- author (s) --> \n" +
            "    <strong>Authors</strong>: \n" +
            "    <a itemprop=\"author\" href=\"/doab?func=search&amp;query=au:&quot;Marie-Paule Berranger, Myriam Boucharenc (dir.)&quot;&amp;uiLanguage=en\">Marie-Paule Berranger, Myriam Boucharenc (dir.)</a> \n" +
            "    <br> \n" +
            "    <!-- End Loop_au if--> \n" +
            "    <strong>ISBN</strong>: \n" +
            "    <span itemprop=\"isbn\">9782840161219 9782821851054</span> \n" +
            "    <strong>Year</strong>: \n" +
            "    <span itemprop=\"datePublished\">2012</span> \n" +
            "    <strong>Language</strong>: French \n" +
            "    <br>\n" +
            "    <strong>Publisher</strong>: \n" +
            "    <a itemprop=\"publisher\" href=\"/doab?func=publisher&amp;pId=1462&amp;uiLanguage=\">Presses universitaires de Paris Nanterre</a> \n" +
            "    <br>\n" +
            "    <strong>Added to DOAB on </strong>: 2017-05-29 10:33:34 \n" +
            "    <br>License: \n" +
            "    <a href=\"http://www.openedition.org/6540?lang=en\" target=\"blank\">OpenEdition licence for Books</a> \n" +
            "   </div>\n" +
            "   <!-- End color #585858 --> \n" +
            "   <p> </p>\n" +
            "   <div class=\"recordLinks\" id=\"r10\"> \n" +
            "    <h1> <a href=\"javascript:void(0)\" title=\"abs10\"> <span id=\"absLabel10\">Abstract</span> </a> | <a href=\"javascript:void(0)\" title=\"kw10\"> <span id=\"kwLabel10\">Keywords</span> </a> | <a itemprop=\"url\" href=\"/doab?func=fulltext&amp;uiLanguage=en&amp;rid=22109\" target=\"_blank\">Free access</a> | <a href=\"/doab?func=checkAvailability&amp;uiLanguage=en&amp;rid=22109\" class=\"checkAvailable\" title=\"av10\">Buy the book</a> | <a href=\"javascript:void(0)\" title=\"exp10\"> <span id=\"expLabel10\">Export citation</span></a> | <a class=\"addthis_button\" href=\"http://www.addthis.com/bookmark.php?v=300\" addthis:url=\"http://www.doabooks.org/doab?func=search&amp;query=rid:22109\" addthis:title=\"DOAB: À la rencontre...\"><img style=\"border:0\" alt=\"Share\" src=\"/doabImages/addThis.gif\"> </a> </h1> \n" +
            "   </div> \n" +
            "   <!-- END recordLinks --> \n" +
            "   <div class=\"linkContent\"> \n" +
            "    <div id=\"av10\" class=\"tip dyn\">\n" +
            "     <img src=\"/doabImages/spinner.gif\"> Loading...\n" +
            "    </div> \n" +
            "    <div id=\"exp10\" class=\"tip\"> \n" +
            "     <b>Export citation</b> \n" +
            "     <p> Choose an application </p>\n" +
            "     <ul> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=referenceManager&amp;query=22109\"> Reference Manager</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=endNote&amp;query=22109\"> EndNote</a></li> \n" +
            "      <li><a href=\"/doab?func=export&amp;uiLanguage=en&amp;application=refworks&amp;query=22109\" target=\"RefWorksMain\"> RefWorks</a> (Direct export to RefWorks)</li> \n" +
            "     </ul> \n" +
            "    </div> \n" +
            "    <div itemprop=\"description\" id=\"abs10\" class=\"tip\"> \n" +
            "     <b>Abstract</b>\n" +
            "     <p> Ce livre, dédié à Claude Leroy, entend rendre hommage à son activité de professeur et de chercheur, au passeur d’anecdotes curieuses attentif aux noms et aux dates, aux configurations familiales et affectives, aux rencontres capitales et à tout l’insolite de la vie humaine. Celle de Blaise Cendrars s’est peu à peu révélée dans sa complexité au fil de ses éditions critiques, de ses articles et de ses ouvrages : Claude Leroy a découvert, au-delà des images du bourlingueur, de l’homme à la main ... </p>\n" +
            "    </div> \n" +
            "    <div id=\"kw10\" class=\"tip\"> \n" +
            "     <b>Keywords</b>\n" +
            "     <p> \n" +
            "      <!-- Multi --> <a itemprop=\"keywords\" href=\"/doab?func=search&amp;uiLanguage=en&amp;query=kw:&quot;Claude Leroy, Blaise Cendrars, romantisme (littérature)&quot;\">Claude Leroy, Blaise Cendrars, romantisme (littérature)</a> </p>\n" +
            "    </div> \n" +
            "   </div> \n" +
            "   <!-- END linkContent --> \n" +
            "  </div> \n" +
            "  <!-- END data --> \n" +
            "  <div style=\"clear:both\"></div> \n" +
            " </div> \n" +
            " <!-- END record ---> \n" +
            "</div>]";


    @Test
    public void test() {
        task.task();

    }

    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void test3() {
        List<BookEntity> all = bookRepository.findAll();

    }

    @Test
    public void test2() {

        Html html1 = new Html(s);
        List<Selectable> nodes = html1.xpath("//div[@itemtype='http://schema.org/Book']").nodes();

        for (Selectable node : nodes) {
            String img = "http://schema.org/Book" + node.xpath("//div[@class='imageDiv']/img/@src").get();
            String name = node.xpath("//div[@class='data']/b/span[@itemprop='name']/text()").get();
            String author = node.xpath("//div[@class='data']/div[@style='color: #585858']/a[@itemprop='author']/text()").get();
            String isbn = node.xpath("//div[@class='data']/div[@style='color: #585858']/span[@itemprop='isbn']/text()").get().replaceAll(" ", ",");
            String year = node.xpath("//div[@class='data']/div[@style='color: #585858']/span[@itemprop='datePublished']/text()").get();
            String pages = node.xpath("//div[@class='data']/div[@style='color: #585858']/span[@itemprop='numberOfPages']/text()").get();
            String publisher = node.xpath("//div[@class='data']/div[@style='color: #585858']/a[@itemprop='publisher']/text()").get();
            String subject = node.xpath("//div[@class='data']/div[@style='color: #585858']/a[@itemprop='about']/text()").get();
            String description = node.xpath("//div[@class='data']/div[@class='linkContent']/div[@itemprop='description']/p/text()").get();
            List<String> Keywords = node.xpath("//div[@class='data']/div[@class='linkContent']/div/p/a[@itemprop='keywords']/text()").all();
            Selectable replace = node.replace("\n", "")
                    .replace("\r", "")
                    .replace("\t", "");
            String language = replace.regex("<strong>Language</strong>:(.*?)<br>").get();
            String doi = replace.regex("<strong>DOI</strong>:(.*?)<strong>Language</strong>").get();
            String dateOfAddDoab = replace.regex("<strong>Added to DOAB on </strong>:(.*?)<br>").get();

            log.info("author={}", author);
            log.info("name={}", name);
            log.info("img={}", img);
            log.info("isbn={}", isbn);
            log.info("year={}", year);
            log.info("pages={}", pages);
            log.info("publisher={}", publisher);
            log.info("subject={}", subject);
            log.info("description={}", description);
            log.info("Keywords={}", StringUtils.strip(Keywords.toString(), "[]"));
            log.info("doi={}", doi);
            log.info("language={}", language);
            log.info("dateOfAddDoab={}", dateOfAddDoab);
        }
    }

    @Test
    public void initArray() {
        char[] array = DoabUtil.initArray();
        log.info("array={}", Arrays.toString(array));
    }


}
