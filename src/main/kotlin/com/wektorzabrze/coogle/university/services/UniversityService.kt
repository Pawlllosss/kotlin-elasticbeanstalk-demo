package com.wektorzabrze.coogle.university.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.wektorzabrze.coogle.infrastructure.asList
import com.wektorzabrze.coogle.university.University
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import java.io.File

@Service
class UniversityService(objectMapper: ObjectMapper) {

    private lateinit var universities: Collection<University>

    init {
        universities = objectMapper.asList(mockData, University::class.java)
        println(universities)
    }

    fun getUniversities(): Collection<University> = universities.map { it.copy() }
    fun addFavouriteUniversity(id: String) {
        universities.first { it.id == id }.isFavourite = true
    }

    fun removeFavouriteUniversity(id: String) {
        universities.first { it.id == id }.isFavourite = false
    }
}

private fun getFileFromResources(filename: String): File {
    val resource = ClassPathResource(filename)

    return resource.file
}


private val mockData: String = """[
    {
        "name": "Akademia Górniczo-Hutnicza",
        "photoUrl": "https://galeria.bankier.pl/p/9/1/67dd4bfafb57a9-945-560-45-168-4455-2672.jpg",
        "courseDegrees": [
            {
                "name": "Informatyka",
                "category": "INFORMATION",
                "description": "Zdobądź podstawy informatyki i programowania.",
                "finalsSubjects": ["Matematyka", "Fizyka", "Informatyka"],
                "interests": ["Programowanie", "Analiza Danych"],
                "occupancy": {
                    "noPlaces": 100,
                    "noCandidates": 80
                },
                "language": "Polski",
                "occupations": ["Programista", "Analityk Danych", "Inżynier Oprogramowania"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 0.8,
                        "angielski": 0.2
                    },
                    "minThreshold": 90
                }
            },
            {
                "name": "Elektronika",
                "category": "ENGINEERING",
                "description": "Studiuj systemy elektryczne, elektronikę i inżynierię energetyczną.",
                "finalsSubjects": ["Matematyka", "Fizyka", "Informatyka"],
                "interests": ["Energia Odnawialna", "Projektowanie Elektroniki"],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 90
                },
                "language": "Polski",
                "occupations": ["Inżynier Elektroniki", "Projektant Układów Elektronicznych"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "fizyka": 0.8,
                        "angielski": 0.2
                    },
                    "minThreshold": 80
                }
            },
            {
                "name": "Inżynieria Mechaniczna",
                "category": "ENGINEERING",
                "description": "Zdobądź podstawy mechaniki i projektowania systemów mechanicznych.",
                "finalsSubjects": ["Matematyka", "Fizyka", "Informatyka"],
                "interests": ["Inżynieria Samochodowa", "Robotyka"],
                "occupancy": {
                    "noPlaces": 150,
                    "noCandidates": 120
                },
                "language": "Polski",
                "occupations": ["Inżynier Mechanik", "Projektant Maszyn"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "fizyka": 0.8,
                        "angielski": 0.2
                    },
                    "minThreshold": 60
                }
            },
            {
                "name": "Górnictwo",
                "category": "ENGINEERING",
                "description": "Zbadaj ekstrakcję cennych minerałów z ziemi.",
                "finalsSubjects": ["Matematyka", "Fizyka", "Chemia"],
                "interests": ["Operacje Górnicze", "Zrównoważone Zarządzanie Zasobami"],
                "occupancy": {
                    "noPlaces": 80,
                    "noCandidates": 60
                },
                "language": "Polski",
                "occupations": ["Inżynier Górnik", "Specjalista ds. Zrównoważonego Rozwoju"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "fizyka": 0.8,
                        "angielski": 0.2
                    },
                    "minThreshold": 30
                }
            },
            {
                "name": "Matematyka Stosowana",
                "category": "SCIENCE",
                "description": "Studiuj teorie matematyczne i ich praktyczne zastosowania.",
                "finalsSubjects": ["Matematyka", "Fizyka", "Informatyka"],
                "interests": ["Modelowanie Matematyczne", "Analiza Numeryczna"],
                "occupancy": {
                    "noPlaces": 90,
                    "noCandidates": 70
                },
                "language": "Polski",
                "occupations": ["Analityk Matematyczny", "Specjalista ds. Analizy Numerycznej"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 1.0
                    },
                    "minThreshold": 50
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Kraków",
            "street": "Mickiewicza",
            "buildingNumber": "30"
        },
        "coordinates": {
            "latitude": 50.0671,
            "longitude": 19.9073
        },
        "amenities": [
            {
                "name": "Kawiarnia na Kampusie",
                "type": "RESTAURANT",
                "distance": 200
            },
            {
                "name": "Centrum Rekreacji Studenckiej",
                "type": "RECREATION",
                "distance": 300
            },
            {
                "name": "Księgarnia",
                "type": "EDUCATIONAL",
                "distance": 150
            }
        ],
        "accessibilitiesForDisabled": ["Rampa", "Winda", "Schody Ruchome", "Audiodeskrypcja", "Przyciski Braille'a"],
        "clubs": [
            {
                "name": "Klub Programistyczny",
                "description": "Społeczność studentów pasjonujących się programowaniem."
            },
            {
                "name": "Stowarzyszenie Inżynierów",
                "description": "Łączenie studentów inżynierii i promowanie innowacji."
            }
        ],
        "siteURL": "https://www.agh.edu.pl/",
        "scholarships": ["Stypendium socjalne"]
    },
    {
        "name": "Uniwersytet Jagielloński",
        "photoUrl": "https://www.uj.edu.pl/documents/10172/153457045/novumm-685.jpg/ddf817b8-d18f-47dc-bb1c-b3dc90b7238d?t=1683708003900",
        "courseDegrees": [
            {
                "name": "Fizyka",
                "category": "SCIENCE",
                "description": "Zbadaj podstawowe zasady materii i energii.",
                "finalsSubjects": ["Matematyka", "Fizyka", "Chemia"],
                "interests": ["Fizyka Teoretyczna", "Fizyka Eksperymentalna"],
                "occupancy": {
                    "noPlaces": 100,
                    "noCandidates": 80
                },
                "language": "Polski",
                "occupations": ["Badacz Fizyczny", "Nauczyciel Akademicki"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "fizyka": 1.0
                    },
                    "minThreshold": 90
                }
            },
            {
                "name": "Medycyna",
                "category": "MEDICINE",
                "description": "Studiuj naukę i praktykę diagnozowania, leczenia i zapobiegania chorobom.",
                "finalsSubjects": ["Biologia", "Chemia", "Fizyka"],
                "interests": ["Badania Medyczne", "Opieka Nad Pacjentem"],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 90
                },
                "language": "Polski",
                "occupations": ["Lekarz", "Specjalista ds. Badań Medycznych"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "bilogia": 0.5,
                        "chemia": 0.5
                    },
                    "minThreshold": 95
                }
            },
            {
                "name": "Inżynieria Komputerowa",
                "category": "ENGINEERING",
                "description": "Łącz zasady informatyki z inżynierią elektryczną.",
                "finalsSubjects": ["Matematyka", "Fizyka", "Informatyka"],
                "interests": ["Projektowanie Sprzętu", "Programowanie"],
                "occupancy": {
                    "noPlaces": 80,
                    "noCandidates": 60
                },
                "language": "Polski",
                "occupations": ["Inżynier Komputerowy", "Programista Sprzętu"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 1.0
                    },
                    "minThreshold": 90
                }
            },
            {
                "name": "Biotechnologia",
                "category": "SCIENCE",
                "description": "Stosuj procesy biologiczne, organizmy lub systemy do opracowywania nowych technologii.",
                "finalsSubjects": ["Biologia", "Chemia", "Matematyka"],
                "interests": ["Zastosowania Biomedyczne", "Biotechnologia Środowiskowa"],
                "occupancy": {
                    "noPlaces": 90,
                    "noCandidates": 70
                },
                "language": "Polski",
                "occupations": ["Biotechnolog", "Specjalista ds. Badań Biomedycznych"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "biologia": 1.0
                    },
                    "minThreshold": 45
                }
            },
            {
                "name": "Geografia",
                "category": "NATURAL",
                "description": "Studiuj krajobrazy, środowiska i związki między ludźmi a ich środowiskiem.",
                "finalsSubjects": ["Geografia", "Biologia", "Matematyka"],
                "interests": ["Studia Środowiskowe", "Planowanie Przestrzenne"],
                "occupancy": {
                    "noPlaces": 150,
                    "noCandidates": 120
                },
                "language": "Polski",
                "occupations": ["Geograf", "Urbanista"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "geografia": 1.0
                    },
                    "minThreshold": 30
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Kraków",
            "street": "Gołębia",
            "buildingNumber": "24"
        },
        "coordinates": {
            "latitude": 50.0537,
            "longitude": 19.9353
        },
        "amenities": [
            {
                "name": "Biblioteka Uniwersytecka",
                "type": "EDUCATIONAL",
                "distance": 100
            },
            {
                "name": "Pałac Wiedzy",
                "type": "EDUCATIONAL",
                "distance": 650
            },
            {
                "name": "Restauracja Wykwintna",
                "type": "RESTAURANT",
                "distance": 250
            },
            {
                "name": "Oaza Zen Fitness",
                "type": "RECREATION",
                "distance": 800
            },
            {
                "name": "Budynek Centrum Społecznego",
                "type": "EDUCATIONAL",
                "distance": 350
            }
        ],
        "accessibilitiesForDisabled": ["Rampa", "Winda", "Podjazd Dla Rowerów", "Tablica Komunikacyjna", "Asystent Osobisty"],
        "clubs": [
            {
                "name": "Koło Naukowe Fizyki",
                "description": "Łączenie entuzjastów fizyki i organizowanie wydarzeń naukowych."
            },
            {
                "name": "Studenckie Stowarzyszenie Medyczne",
                "description": "Promowanie współpracy między studentami medycyny i profesjonalistami."
            },
            {
                "name": "Klub Geograficzny",
                "description": "Badanie zjawisk geograficznych i promowanie świadomości środowiskowej."
            }
        ],
        "siteURL": "https://www.uj.edu.pl/",
        "scholarships": ["Stypendium socjalne", "Stypendium dla Olimpijczyków"]
    },
    {
        "name": "Uniwersytet Ekonomiczny w Krakowie",
        "photoUrl": "https://biznes.uek.krakow.pl/wp-content/uploads/2018/10/uek_doradztwo_badania_ekspertyzy.jpg",
        "courseDegrees": [
            {
                "name": "Ekonomia",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Studiuj produkcję, dystrybucję i konsumpcję dóbr i usług.",
                "finalsSubjects": ["Matematyka", "Ekonomia", "Angielski"],
                "interests": ["Polityka Gospodarcza", "Analiza Finansowa"],
                "occupancy": {
                    "noPlaces": 100,
                    "noCandidates": 80
                },
                "language": "Polski",
                "occupations": ["Ekonomista", "Analityk Finansowy", "Konsultant ds. Polityki Gospodarczej"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 1.0
                    },
                    "minThreshold": 40
                }
            },
            {
                "name": "Zarządzanie",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Badaj zasady planowania, organizacji i kierowania zasobami.",
                "finalsSubjects": ["Matematyka", "Ekonomia", "Angielski"],
                "interests": ["Przywództwo", "Strategia Biznesowa"],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 90
                },
                "language": "Polski",
                "occupations": ["Manager", "Specjalista ds. Zarządzania Zasobami Ludzkimi"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 1.0
                    },
                    "minThreshold": 10
                }
            },
            {
                "name": "Międzynarodowe Stosunki Gospodarcze",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Studiuj działalność gospodarczą, która obejmuje wymianę międzynarodową.",
                "finalsSubjects": ["Matematyka", "Ekonomia", "Angielski"],
                "interests": ["Globalny Marketing", "Międzynarodowe Finanse", "Zarządzanie Międzykulturowe"],
                "occupancy": {
                    "noPlaces": 80,
                    "noCandidates": 60
                },
                "language": "Polski",
                "occupations": ["Specjalista ds. Międzynarodowych Stosunków Gospodarczych", "Dyplomata"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "polski": 1.0
                    },
                    "minThreshold": 30
                }
            },
            {
                "name": "Finanse i Rachunkowość",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Badaj zarządzanie finansowe, zasady rachunkowości i strategie inwestycyjne.",
                "finalsSubjects": ["Matematyka", "Ekonomia", "Angielski"],
                "interests": ["Planowanie Finansowe", "Finanse Korporacyjne"],
                "occupancy": {
                    "noPlaces": 90,
                    "noCandidates": 70
                },
                "language": "Polski",
                "occupations": ["Księgowy", "Controller Finansowy"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 1.0
                    },
                    "minThreshold": 60
                }
            },
            {
                "name": "Informatyka w Zarządzaniu",
                "category": "INFORMATION",
                "description": "Stosuj technologię informacyjną do wsparcia zarządzania i podejmowania decyzji.",
                "finalsSubjects": ["Informatyka", "Matematyka", "Angielski"],
                "interests": ["Analiza Danych", "Governance IT"],
                "occupancy": {
                    "noPlaces": 150,
                    "noCandidates": 120
                },
                "language": "Polski",
                "occupations": ["Specjalista ds. Informatyki Zarządczej", "Analityk Biznesowy"],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 1.0
                    },
                    "minThreshold": 90
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Kraków",
            "street": "Rakowicka",
            "buildingNumber": "27"
        },
        "coordinates": {
            "latitude": 50.0647,
            "longitude": 19.9406
        },
        "amenities": [
            {
                "name": "Biblioteka Ekonomii i Biznesu",
                "type": "EDUCATIONAL",
                "distance": 120
            },
            {
                "name": "Mado",
                "type": "SHOP",
                "distance": 180
            },
            {
                "name": "Centrum Studenckie",
                "type": "RECREATION",
                "distance": 250
            }
        ],
        "accessibilitiesForDisabled": ["Rampa", "Winda", "Podjazd Dla Rowerów", "Tablica Komunikacyjna", "Asystent Osobisty"],
        "clubs": [
            {
                "name": "Klub Ekonomii",
                "description": "Promowanie dyskusji ekonomicznych i organizacja wydarzeń na temat trendów gospodarczych."
            },
            {
                "name": "Stowarzyszenie Zarządzania",
                "description": "Łączenie studentów zainteresowanych zasadami i praktykami zarządzania."
            },
            {
                "name": "Międzynarodowa Sieć Biznesowa",
                "description": "Promowanie wymiany kulturowej i zrozumienia w kontekście biznesowym."
            }
        ],
        "siteURL": "https://uek.krakow.pl/",
        "scholarships": ["Stypendium socjalne", "Stypendium Sportowe", "Stypendium dla Olimpijczyków"]
    }
]""".trimIndent()