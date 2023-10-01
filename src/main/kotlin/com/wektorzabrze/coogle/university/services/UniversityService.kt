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
        "rating": "83.1",
        "photoUrl": "https://galeria.bankier.pl/p/9/1/67dd4bfafb57a9-945-560-45-168-4455-2672.jpg",
        "courseDegrees": [
            {
                "name": "Informatyka",
                "category": "INFORMATION",
                "description": "Zdobądź podstawy informatyki i programowania.",
                "finalsSubjects": [
                    "Matematyka",
                    "Fizyka",
                    "Informatyka"
                ],
                "interests": [
                    "Programowanie",
                    "Analiza Danych"
                ],
                "occupancy": {
                    "noPlaces": 100,
                    "noCandidates": 80
                },
                "language": "Polski",
                "occupations": [
                    "Programista",
                    "Analityk Danych",
                    "Inżynier Oprogramowania"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 0.8,
                        "angielski": 0.2
                    },
                    "minThreshold": 90
                },
                "level": "2",
                "tuition": 0,
                "earningsMedian": 7500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do programowania",
                                "Matematyka dyskretna"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Algorytmy i struktury danych",
                                "Programowanie obiektowe"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Bazy danych",
                                "Analiza i projektowanie systemów"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Elektronika",
                "category": "ENGINEERING",
                "description": "Studiuj systemy elektryczne, elektronikę i inżynierię energetyczną.",
                "finalsSubjects": [
                    "Matematyka",
                    "Fizyka",
                    "Informatyka"
                ],
                "interests": [
                    "Energia Odnawialna",
                    "Projektowanie Elektroniki"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 90
                },
                "language": "Polski",
                "occupations": [
                    "Inżynier Elektroniki",
                    "Projektant Układów Elektronicznych"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "fizyka": 0.8,
                        "angielski": 0.2
                    },
                    "minThreshold": 80
                },
                "level": "1inz",
                "tuition": 0,
                "earningsMedian": 7000,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy elektroniki",
                                "Matematyka dla inżynierów"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Fizyka techniczna",
                                "Algorytmy i struktury danych"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Systemy mikroprocesorowe",
                                "Energia odnawialna"
                            ]
                        },
                        {
                            "ordinal": 4,
                            "subjects": [
                                "Komunikacja bezprzewodowa",
                                "Elektronika wysokich częstotliwości"
                            ]
                        },
                        {
                            "ordinal": 5,
                            "subjects": [
                                "Projektowanie układów VLSI",
                                "Metrologia elektroniczna"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Inżynieria Mechaniczna",
                "category": "ENGINEERING",
                "description": "Zdobądź podstawy mechaniki i projektowania systemów mechanicznych.",
                "finalsSubjects": [
                    "Matematyka",
                    "Fizyka",
                    "Informatyka"
                ],
                "interests": [
                    "Inżynieria Samochodowa",
                    "Robotyka"
                ],
                "occupancy": {
                    "noPlaces": 150,
                    "noCandidates": 120
                },
                "language": "Polski",
                "occupations": [
                    "Inżynier Mechanik",
                    "Projektant Maszyn"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "fizyka": 0.8,
                        "angielski": 0.2
                    },
                    "minThreshold": 60
                },
                "level": "2",
                "tuition": 0,
                "earningsMedian": 7200,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy mechaniki",
                                "Matematyka dla inżynierów"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Technologie materiałowe",
                                "Rysunek techniczny"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Modelowanie komputerowe",
                                "Inżynieria oprogramowania"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Górnictwo",
                "category": "ENGINEERING",
                "description": "Zbadaj ekstrakcję cennych minerałów z ziemi.",
                "finalsSubjects": [
                    "Matematyka",
                    "Fizyka",
                    "Chemia"
                ],
                "interests": [
                    "Operacje Górnicze",
                    "Zrównoważone Zarządzanie Zasobami"
                ],
                "occupancy": {
                    "noPlaces": 80,
                    "noCandidates": 60
                },
                "language": "Polski",
                "occupations": [
                    "Inżynier Górnik",
                    "Specjalista ds. Zrównoważonego Rozwoju"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "fizyka": 0.8,
                        "angielski": 0.2
                    },
                    "minThreshold": 30
                },
                "level": "2",
                "tuition": 0,
                "earningsMedian": 6800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Geologia górnicza",
                                "Matematyka dla górnictwa"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Fizyka górnicza",
                                "Chemia górnicza"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Zrównoważone zarządzanie zasobami",
                                "Eksploatacja surowców mineralnych"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Matematyka Stosowana",
                "category": "SCIENCE",
                "description": "Studiuj teorie matematyczne i ich praktyczne zastosowania.",
                "finalsSubjects": [
                    "Matematyka",
                    "Fizyka",
                    "Informatyka"
                ],
                "interests": [
                    "Modelowanie Matematyczne",
                    "Analiza Numeryczna"
                ],
                "occupancy": {
                    "noPlaces": 90,
                    "noCandidates": 70
                },
                "language": "Polski",
                "occupations": [
                    "Analityk Matematyczny",
                    "Specjalista ds. Analizy Numerycznej"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 1.0
                    },
                    "minThreshold": 50
                },
                "level": "1inz",
                "tuition": 0,
                "earningsMedian": 7800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Analiza matematyczna",
                                "Algebra liniowa"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Równania różniczkowe",
                                "Geometria analityczna"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Teoria prawdopodobieństwa",
                                "Statystyka matematyczna"
                            ]
                        },
                        {
                            "ordinal": 4,
                            "subjects": [
                                "Optymalizacja matematyczna",
                                "Teoria gier"
                            ]
                        },
                        {
                            "ordinal": 5,
                            "subjects": [
                                "Analiza funkcjonalna",
                                "Metody numeryczne w praktyce"
                            ]
                        }
                    ]
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
            "latitude": 50.064528,
            "longitude": 19.923556
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
        "accessibilitiesForDisabled": [
            "Rampa",
            "Winda",
            "Schody Ruchome",
            "Audiodeskrypcja",
            "Przyciski Braille'a"
        ],
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
        "scholarships": [
            "Stypendium socjalne"
        ]
    },
    {
        "name": "Uniwersytet Jagielloński",
        "rating": "100.0",
        "photoUrl": "https://www.uj.edu.pl/documents/10172/153457045/novumm-685.jpg/ddf817b8-d18f-47dc-bb1c-b3dc90b7238d?t=1683708003900",
        "courseDegrees": [
            {
                "name": "Fizyka",
                "category": "SCIENCE",
                "description": "Zbadaj podstawowe zasady materii i energii.",
                "finalsSubjects": [
                    "Matematyka",
                    "Fizyka",
                    "Chemia"
                ],
                "interests": [
                    "Fizyka Teoretyczna",
                    "Fizyka Eksperymentalna"
                ],
                "occupancy": {
                    "noPlaces": 100,
                    "noCandidates": 80
                },
                "language": "Polski",
                "occupations": [
                    "Badacz Fizyczny",
                    "Nauczyciel Akademicki"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "fizyka": 1.0
                    },
                    "minThreshold": 90
                },
                "level": "2jednolite",
                "tuition": 0,
                "earningsMedian": 7800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Mechanika klasyczna",
                                "Teoria kwantowa"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Elektrodynamika",
                                "Fizyka statystyczna"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Fizyka ciała stałego",
                                "Fizyka jądrowa i cząstek elementarnych"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Medycyna",
                "category": "MEDICINE",
                "description": "Studiuj naukę i praktykę diagnozowania, leczenia i zapobiegania chorobom.",
                "finalsSubjects": [
                    "Biologia",
                    "Chemia",
                    "Fizyka"
                ],
                "interests": [
                    "Badania Medyczne",
                    "Opieka Nad Pacjentem"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 90
                },
                "language": "Polski",
                "occupations": [
                    "Lekarz",
                    "Specjalista ds. Badań Medycznych"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "bilogia": 0.5,
                        "chemia": 0.5
                    },
                    "minThreshold": 95
                },
                "level": "2jednolite",
                "tuition": 0,
                "earningsMedian": 9200,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Mechanika klasyczna",
                                "Teoria kwantowa"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Elektrodynamika",
                                "Fizyka statystyczna"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Fizyka ciała stałego",
                                "Fizyka jądrowa i cząstek elementarnych"
                            ]
                        },
                        {
                            "ordinal": 4,
                            "subjects": [
                                "Astrofizyka",
                                "Fizyka plazmy"
                            ]
                        },
                        {
                            "ordinal": 5,
                            "subjects": [
                                "Fizyka medyczna",
                                "Fizyka atmosfery i klimat"
                            ]
                        },
                        {
                            "ordinal": 6,
                            "subjects": [
                                "Fizyka techniczna",
                                "Fizyka nanomateriałów"
                            ]
                        },
                        {
                            "ordinal": 7,
                            "subjects": [
                                "Fizyka polimerów",
                                "Fizyka zjawisk ultrafast"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Inżynieria Komputerowa",
                "category": "ENGINEERING",
                "description": "Łącz zasady informatyki z inżynierią elektryczną.",
                "finalsSubjects": [
                    "Matematyka",
                    "Fizyka",
                    "Informatyka"
                ],
                "interests": [
                    "Projektowanie Sprzętu",
                    "Programowanie"
                ],
                "occupancy": {
                    "noPlaces": 80,
                    "noCandidates": 60
                },
                "language": "Polski",
                "occupations": [
                    "Inżynier Komputerowy",
                    "Programista Sprzętu"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 1.0
                    },
                    "minThreshold": 90
                },
                "level": "2",
                "tuition": 0,
                "earningsMedian": 8500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Logika matematyczna",
                                "Algorytmy i struktury danych"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Architektura komputerów",
                                "Sieci komputerowe"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Projektowanie układów cyfrowych",
                                "Sztuczna inteligencja"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Biotechnologia",
                "category": "SCIENCE",
                "description": "Stosuj procesy biologiczne, organizmy lub systemy do opracowywania nowych technologii.",
                "finalsSubjects": [
                    "Biologia",
                    "Chemia",
                    "Matematyka"
                ],
                "interests": [
                    "Zastosowania Biomedyczne",
                    "Biotechnologia Środowiskowa"
                ],
                "occupancy": {
                    "noPlaces": 90,
                    "noCandidates": 70
                },
                "language": "Polski",
                "occupations": [
                    "Biotechnolog",
                    "Specjalista ds. Badań Biomedycznych"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "biologia": 1.0
                    },
                    "minThreshold": 45
                },
                "level": "1lic",
                "tuition": 0,
                "earningsMedian": 7800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Biologia molekularna",
                                "Chemia organiczna"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Inżynieria genetyczna",
                                "Bioinformatyka"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Biologia komórkowa",
                                "Technologia komórkowa"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Geografia",
                "category": "NATURAL",
                "description": "Studiuj krajobrazy, środowiska i związki między ludźmi a ich środowiskiem.",
                "finalsSubjects": [
                    "Geografia",
                    "Biologia",
                    "Matematyka"
                ],
                "interests": [
                    "Studia Środowiskowe",
                    "Planowanie Przestrzenne"
                ],
                "occupancy": {
                    "noPlaces": 150,
                    "noCandidates": 120
                },
                "language": "Polski",
                "occupations": [
                    "Geograf",
                    "Urbanista"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "geografia": 1.0
                    },
                    "minThreshold": 30
                },
                "level": "2",
                "tuition": 0,
                "earningsMedian": 7200,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy geografii",
                                "Wstęp do biologii"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Geografia fizyczna",
                                "Biologia komórkowa"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Statystyka w geografii",
                                "Algebra i geometria"
                            ]
                        }
                    ]
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
            "latitude": 50.0610645,
            "longitude": 19.9328982
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
        "accessibilitiesForDisabled": [
            "Rampa",
            "Winda",
            "Podjazd Dla Rowerów",
            "Tablica Komunikacyjna",
            "Asystent Osobisty"
        ],
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
        "scholarships": [
            "Stypendium socjalne",
            "Stypendium dla Olimpijczyków"
        ]
    },
    {
        "name": "Uniwersytet Ekonomiczny w Krakowie",
        "rating": "53.0",
        "photoUrl": "https://biznes.uek.krakow.pl/wp-content/uploads/2018/10/uek_doradztwo_badania_ekspertyzy.jpg",
        "courseDegrees": [
            {
                "name": "Ekonomia",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Studiuj produkcję, dystrybucję i konsumpcję dóbr i usług.",
                "finalsSubjects": [
                    "Matematyka",
                    "Ekonomia",
                    "Angielski"
                ],
                "interests": [
                    "Polityka Gospodarcza",
                    "Analiza Finansowa"
                ],
                "occupancy": {
                    "noPlaces": 100,
                    "noCandidates": 80
                },
                "language": "Polski",
                "occupations": [
                    "Ekonomista",
                    "Analityk Finansowy",
                    "Konsultant ds. Polityki Gospodarczej"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 1.0
                    },
                    "minThreshold": 40
                },
                "level": "1lic",
                "tuition": 0,
                "earningsMedian": 7800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wstęp do ekonomii",
                                "Podstawy matematyki"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Mikroekonomia",
                                "Rachunkowość finansowa"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Makroekonomia",
                                "Statystyka ekonomiczna"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Zarządzanie",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Badaj zasady planowania, organizacji i kierowania zasobami.",
                "finalsSubjects": [
                    "Matematyka",
                    "Ekonomia",
                    "Angielski"
                ],
                "interests": [
                    "Przywództwo",
                    "Strategia Biznesowa"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 90
                },
                "language": "Polski",
                "occupations": [
                    "Manager",
                    "Specjalista ds. Zarządzania Zasobami Ludzkimi"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 1.0
                    },
                    "minThreshold": 10
                },
                "level": "1lic",
                "tuition": 0,
                "earningsMedian": 8200,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wstęp do zarządzania",
                                "Podstawy matematyki"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Organizacja przedsiębiorstwa",
                                "Psychologia organizacji"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Zarządzanie strategiczne",
                                "Rachunek kosztów"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Międzynarodowe Stosunki Gospodarcze",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Studiuj działalność gospodarczą, która obejmuje wymianę międzynarodową.",
                "finalsSubjects": [
                    "Matematyka",
                    "Ekonomia",
                    "Angielski"
                ],
                "interests": [
                    "Globalny Marketing",
                    "Międzynarodowe Finanse",
                    "Zarządzanie Międzykulturowe"
                ],
                "occupancy": {
                    "noPlaces": 80,
                    "noCandidates": 60
                },
                "language": "Polski",
                "occupations": [
                    "Specjalista ds. Międzynarodowych Stosunków Gospodarczych",
                    "Dyplomata"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "polski": 1.0
                    },
                    "minThreshold": 30
                },
                "level": "2",
                "tuition": 0,
                "earningsMedian": 8800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do stosunków międzynarodowych",
                                "Podstawy ekonomii"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Historia gospodarcza",
                                "Angielski biznesowy"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Prawo międzynarodowe",
                                "Zarządzanie łańcuchem dostaw"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Finanse i Rachunkowość",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Badaj zarządzanie finansowe, zasady rachunkowości i strategie inwestycyjne.",
                "finalsSubjects": [
                    "Matematyka",
                    "Ekonomia",
                    "Angielski"
                ],
                "interests": [
                    "Planowanie Finansowe",
                    "Finanse Korporacyjne"
                ],
                "occupancy": {
                    "noPlaces": 90,
                    "noCandidates": 70
                },
                "language": "Polski",
                "occupations": [
                    "Księgowy",
                    "Controller Finansowy"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 1.0
                    },
                    "minThreshold": 60
                },
                "level": "1lic",
                "tuition": 0,
                "earningsMedian": 7900,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do finansów",
                                "Podstawy rachunkowości"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Analiza finansowa",
                                "Matematyka finansowa"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Finanse międzynarodowe",
                                "Controlling"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Informatyka w Zarządzaniu",
                "category": "INFORMATION",
                "description": "Stosuj technologię informacyjną do wsparcia zarządzania i podejmowania decyzji.",
                "finalsSubjects": [
                    "Informatyka",
                    "Matematyka",
                    "Angielski"
                ],
                "interests": [
                    "Analiza Danych",
                    "Governance IT"
                ],
                "occupancy": {
                    "noPlaces": 150,
                    "noCandidates": 120
                },
                "language": "Polski",
                "occupations": [
                    "Specjalista ds. Informatyki Zarządczej",
                    "Analityk Biznesowy"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 1.0
                    },
                    "minThreshold": 90
                },
                "level": "1lic",
                "tuition": 0,
                "earningsMedian": 8500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do informatyki",
                                "Podstawy matematyki"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Programowanie",
                                "Bazy danych"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Systemy wspomagania decyzji",
                                "Analiza i projektowanie systemów informatycznych"
                            ]
                        }
                    ]
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
            "latitude": 50.0685649,
            "longitude": 19.9551201
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
        "accessibilitiesForDisabled": [
            "Rampa",
            "Winda",
            "Podjazd Dla Rowerów",
            "Tablica Komunikacyjna",
            "Asystent Osobisty"
        ],
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
        "scholarships": [
            "Stypendium socjalne",
            "Stypendium Sportowe",
            "Stypendium dla Olimpijczyków"
        ]
    },
    {
        "name": "Uniwersytet Rolniczy w Krakowie",
        "rating": 54.0,
        "photoUrl": "https://upload.wikimedia.org/wikipedia/commons/3/3f/JKRUK_20070524_AR_Krakow.jpg",
        "courseDegrees": [
            {
                "name": "Rolnictwo",
                "category": "NATURAL",
                "description": "Zajmij się produkcją roślinną i zwierzęcą, zdobądź wiedzę z zakresu agronomii.",
                "finalsSubjects": [
                    "Biologia",
                    "Chemia",
                    "Matematyka"
                ],
                "interests": [
                    "Hodowla Zwierząt",
                    "Zrównoważone Rolnictwo"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 100
                },
                "language": "Polski",
                "occupations": [
                    "Rolnik",
                    "Doradca Rolny",
                    "Specjalista ds. Zrównoważonego Rozwoju"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "biologia": 0.5,
                        "matematyka": 0.5
                    },
                    "minThreshold": 50
                },
                "level": "1lic",
                "tuition": 0,
                "earningsMedian": 6000,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wstęp do agronomii",
                                "Biologia roślin"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Chemia rolno-spożywcza",
                                "Genetyka"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Ochrona roślin",
                                "Matematyka w rolnictwie"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Inżynieria Środowiska",
                "category": "ENGINEERING",
                "description": "Studiuj ochronę środowiska, gospodarkę wodną i problemy zanieczyszczeń.",
                "finalsSubjects": [
                    "Biologia",
                    "Chemia",
                    "Matematyka"
                ],
                "interests": [
                    "Ochrona Powietrza",
                    "Gospodarka Odpadami"
                ],
                "occupancy": {
                    "noPlaces": 90,
                    "noCandidates": 70
                },
                "language": "Polski",
                "occupations": [
                    "Inżynier Środowiska",
                    "Specjalista ds. Ochrony Powietrza"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "biologia": 0.4,
                        "chemia": 0.4,
                        "matematyka": 0.2
                    },
                    "minThreshold": 60
                },
                "level": "1lic",
                "tuition": 0,
                "earningsMedian": 6500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy ochrony środowiska",
                                "Biologia molekularna"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Chemia środowiskowa",
                                "Inżynieria wodna"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Gospodarka odpadami",
                                "Matematyka stosowana w środowisku"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Zootechnika",
                "category": "NATURAL",
                "description": "Zajmij się hodowlą zwierząt, zdobądź wiedzę z zakresu zootechniki.",
                "finalsSubjects": [
                    "Biologia",
                    "Chemia",
                    "Matematyka"
                ],
                "interests": [
                    "Hodowla Zwierząt",
                    "Genetyka Zwierząt"
                ],
                "occupancy": {
                    "noPlaces": 100,
                    "noCandidates": 80
                },
                "language": "Polski",
                "occupations": [
                    "Hodowca Zwierząt",
                    "Specjalista ds. Genetyki Zwierząt"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "biologia": 0.5,
                        "chemia": 0.3,
                        "matematyka": 0.2
                    },
                    "minThreshold": 55
                },
                "level": "1lic",
                "tuition": 0,
                "earningsMedian": 5800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do zootechniki",
                                "Biologia zwierząt"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Chemia organiczna",
                                "Rozród zwierząt"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Genetyka ogólna",
                                "Matematyka w zootechnice"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Kraków",
            "street": "Mickiewicza",
            "buildingNumber": "21"
        },
        "coordinates": {
            "latitude": 50.0649014,
            "longitude": 19.9247613
        },
        "amenities": [
            {
                "name": "Stołówka Studencka",
                "type": "RESTAURANT",
                "distance": 150
            },
            {
                "name": "Klub Naukowy Przyrodniczy",
                "type": "RECREATION",
                "distance": 250
            },
            {
                "name": "Księgarnia Akademicka",
                "type": "EDUCATIONAL",
                "distance": 180
            }
        ],
        "accessibilitiesForDisabled": [
            "Rampa",
            "Winda",
            "Schody Ruchome",
            "Audiodeskrypcja",
            "Przyciski Braille'a"
        ],
        "clubs": [
            {
                "name": "Koło Naukowe Zootechników",
                "description": "Społeczność studencka zainteresowana zootechniką."
            },
            {
                "name": "Klub Ekologii",
                "description": "Dla studentów zainteresowanych ochroną środowiska."
            }
        ],
        "siteURL": "https://urk.edu.pl/",
        "scholarships": [
            "Stypendium socjalne",
            "Stypendium za wyniki w nauce"
        ]
    },
    {
        "name": "Politechnika Krakowska",
        "rating": 61.9,
        "photoUrl": "https://i.nocimg.pl/d11/333/102-krakow-politechnika-krakowska-im-tadeusza.jpg",
        "courseDegrees": [
            {
                "name": "Informatyka",
                "category": "INFORMATION",
                "description": "Zdobądź wiedzę z zakresu informatyki i programowania.",
                "finalsSubjects": [
                    "Matematyka",
                    "Fizyka",
                    "Informatyka"
                ],
                "interests": [
                    "Programowanie",
                    "Sztuczna Inteligencja"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 100
                },
                "language": "Polski",
                "occupations": [
                    "Programista",
                    "Analityk Systemowy",
                    "Inżynier Oprogramowania"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 0.6,
                        "informatyka": 0.4
                    },
                    "minThreshold": 75
                },
                "level": "2",
                "tuition": 0,
                "earningsMedian": 8000,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do programowania",
                                "Matematyka dyskretna"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Algorytmy i struktury danych",
                                "Programowanie obiektowe"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Bazy danych",
                                "Inżynieria oprogramowania"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Inżynieria Elektryczna",
                "category": "ENGINEERING",
                "description": "Studiuj zagadnienia związane z elektrotechniką i elektroniką.",
                "finalsSubjects": [
                    "Matematyka",
                    "Fizyka",
                    "Elektrotechnika"
                ],
                "interests": [
                    "Energetyka",
                    "Automatyka"
                ],
                "occupancy": {
                    "noPlaces": 100,
                    "noCandidates": 80
                },
                "language": "Polski",
                "occupations": [
                    "Inżynier Elektryk",
                    "Specjalista ds. Automatyki",
                    "Projektant Układów Elektronicznych"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 0.5,
                        "fizyka": 0.3,
                        "elektrotechnika": 0.2
                    },
                    "minThreshold": 70
                },
                "level": "1inz",
                "tuition": 0,
                "earningsMedian": 7500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy elektrotechniki",
                                "Matematyka dla inżynierów"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Fizyka techniczna",
                                "Elektronika analogowa"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Automatyka",
                                "Systemy mikroprocesorowe"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Inżynieria Mechaniczna",
                "category": "ENGINEERING",
                "description": "Zdobądź wiedzę z zakresu mechaniki i projektowania konstrukcji.",
                "finalsSubjects": [
                    "Matematyka",
                    "Fizyka",
                    "Informatyka"
                ],
                "interests": [
                    "Konstrukcje Maszyn",
                    "Inżynieria Materiałowa"
                ],
                "occupancy": {
                    "noPlaces": 150,
                    "noCandidates": 120
                },
                "language": "Polski",
                "occupations": [
                    "Inżynier Mechanik",
                    "Projektant Konstrukcji"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 0.4,
                        "fizyka": 0.4,
                        "informatyka": 0.2
                    },
                    "minThreshold": 65
                },
                "level": "2",
                "tuition": 0,
                "earningsMedian": 7800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy mechaniki",
                                "Matematyka dla inżynierów"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Technologie materiałowe",
                                "Rysunek techniczny"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Modelowanie komputerowe",
                                "Inżynieria oprogramowania"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Inżynieria Chemiczna",
                "category": "ENGINEERING",
                "description": "Studiuj procesy chemiczne i technologię materiałów.",
                "finalsSubjects": [
                    "Matematyka",
                    "Chemia",
                    "Fizyka"
                ],
                "interests": [
                    "Technologia Chemiczna",
                    "Inżynieria Materiałowa"
                ],
                "occupancy": {
                    "noPlaces": 80,
                    "noCandidates": 60
                },
                "language": "Polski",
                "occupations": [
                    "Inżynier Procesu",
                    "Technolog Chemiczny",
                    "Inżynier Materiałowy"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 0.4,
                        "chemia": 0.4,
                        "fizyka": 0.2
                    },
                    "minThreshold": 70
                },
                "level": "2",
                "tuition": 0,
                "earningsMedian": 7600,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy chemii",
                                "Matematyka dla inżynierów"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Technologia materiałów",
                                "Chemia organiczna"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Inżynieria reaktorów chemicznych",
                                "Procesy jednostkowe"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Kraków",
            "street": "Warszawska",
            "buildingNumber": "24"
        },
        "coordinates": {
            "latitude": 50.0720447,
            "longitude": 19.9427642
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
                "name": "Sklep Akademicki",
                "type": "SHOP",
                "distance": 200
            }
        ],
        "accessibilitiesForDisabled": [
            "Rampa",
            "Winda",
            "Schody Ruchome",
            "Audiodeskrypcja",
            "Przyciski Braille'a"
        ],
        "clubs": [
            {
                "name": "Koło Naukowe Inżynierów Mechaników",
                "description": "Społeczność studentów inżynierii mechanicznej."
            },
            {
                "name": "Klub Chemików",
                "description": "Dla pasjonatów chemii i inżynierii chemicznej."
            }
        ],
        "siteURL": "https://www.pk.edu.pl/",
        "scholarships": [
            "Stypendium socjalne",
            "Stypendium za wyniki w nauce"
        ]
    },
    {
        "name": "Wyższa Szkoła Zarządzania i Bankowości",
        "rating": 36.4,
        "photoUrl": "https://www.pomaturze.pl/pliki/galeria/wyzsza_szkola_zarzadzania_i_bankowosci_krakow_2021.jpg",
        "courseDegrees": [
            {
                "name": "Zarządzanie",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Studiuj teorie i praktykę zarządzania firmami.",
                "finalsSubjects": [
                    "Ekonomia",
                    "Zarządzanie",
                    "Psychologia Organizacji"
                ],
                "interests": [
                    "Strategiczne Planowanie",
                    "Negocjacje Biznesowe"
                ],
                "occupancy": {
                    "noPlaces": 80,
                    "noCandidates": 60
                },
                "language": "Polski",
                "occupations": [
                    "Manager",
                    "Specjalista ds. Zarządzania Projektem"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "ekonomia": 0.4,
                        "zarządzanie": 0.4,
                        "psychologia": 0.2
                    },
                    "minThreshold": 70
                },
                "level": "1",
                "tuition": 3000,
                "earningsMedian": 7000,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do ekonomii",
                                "Podstawy zarządzania"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Psychologia organizacji",
                                "Rachunkowość"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Marketing",
                                "Zarządzanie projektami"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Bankowość",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Zdobądź wiedzę z zakresu bankowości i finansów.",
                "finalsSubjects": [
                    "Rachunkowość",
                    "Finanse",
                    "Prawo Bankowe"
                ],
                "interests": [
                    "Analiza Finansowa",
                    "Bankowość Inwestycyjna"
                ],
                "occupancy": {
                    "noPlaces": 100,
                    "noCandidates": 80
                },
                "language": "Polski",
                "occupations": [
                    "Analityk Finansowy",
                    "Specjalista ds. Produktów Bankowych"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "rachunkowosc": 0.4,
                        "finanse": 0.4,
                        "prawo": 0.2
                    },
                    "minThreshold": 75
                },
                "level": "2",
                "tuition": 3200,
                "earningsMedian": 7500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy rachunkowości",
                                "Finanse przedsiębiorstw"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Prawo bankowe",
                                "Bankowość inwestycyjna"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Systemy płatności",
                                "Audyt finansowy"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "E-Commerce",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Studiuj technologie e-commerce i elektronicznego biznesu.",
                "finalsSubjects": [
                    "Informatyka",
                    "Marketing internetowy",
                    "Analiza rynku e-commerce"
                ],
                "interests": [
                    "E-Biznes",
                    "E-Marketing"
                ],
                "occupancy": {
                    "noPlaces": 60,
                    "noCandidates": 50
                },
                "language": "Polski",
                "occupations": [
                    "Specjalista ds. E-Commerce",
                    "Kierownik Sklepu Internetowego"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "informatyka": 0.5,
                        "marketing": 0.3,
                        "analiza": 0.2
                    },
                    "minThreshold": 80
                },
                "level": "2",
                "tuition": 3400,
                "earningsMedian": 7800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Informatyka",
                                "Podstawy marketingu"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Analiza rynku e-commerce",
                                "Technologie e-biznesu"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Zarządzanie relacjami z klientem",
                                "Bezpieczeństwo e-commerce"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PRIVATE",
        "address": {
            "city": "Kraków",
            "street": "aleja Kijowska",
            "buildingNumber": "14"
        },
        "coordinates": {
            "latitude": 50.0719303,
            "longitude": 19.9153768
        },
        "amenities": [
            {
                "name": "Kawiarnia Studencka",
                "type": "RESTAURANT",
                "distance": 150
            },
            {
                "name": "Klub Biznesowy",
                "type": "RECREATION",
                "distance": 200
            },
            {
                "name": "Sklep Edukacyjny",
                "type": "EDUCATIONAL",
                "distance": 180
            }
        ],
        "accessibilitiesForDisabled": [
            "Rampa",
            "Winda",
            "Schody Ruchome",
            "Audiodeskrypcja",
            "Przyciski Braille'a"
        ],
        "clubs": [
            {
                "name": "Koło Naukowe Zarządzania",
                "description": "Społeczność studentów zainteresowanych zarządzaniem."
            },
            {
                "name": "Klub Finansowy",
                "description": "Dla miłośników finansów i bankowości."
            }
        ],
        "siteURL": "https://www.wszib.edu.pl/",
        "scholarships": [
            "Stypendium za wyniki w nauce",
            "Stypendium sportowe"
        ]
    },
    {
        "name": "Uniwersytet Warszawski",
        "rating": 99.6,
        "photoUrl": "https://ipla.pluscdn.pl/dituel/cp/nj/nj6cd5nrokpvayzidvyo3hwzr6g4hppa.jpg",
        "courseDegrees": [
            {
                "name": "Informatyka",
                "category": "ENGINEERING",
                "description": "Bachelor's degree in Computer Science.",
                "finalsSubjects": [
                    "Computer Programming",
                    "Algorithms",
                    "Database Management"
                ],
                "interests": [
                    "Artificial Intelligence",
                    "Web Development"
                ],
                "occupancy": {
                    "noPlaces": 150,
                    "noCandidates": 120
                },
                "language": "Polish",
                "occupations": [
                    "Software Engineer",
                    "Data Analyst"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Computer Programming": 0.4,
                        "Algorithms": 0.4,
                        "Database Management": 0.2
                    },
                    "minThreshold": 75
                },
                "level": "Bachelor",
                "tuition": 4000,
                "earningsMedian": 6000,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Introduction to Programming",
                                "Discrete Mathematics"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Data Structures",
                                "Computer Networks"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Machine Learning",
                                "Web Development"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Psychologia",
                "category": "HUMANISTIC",
                "description": "Bachelor's degree in Psychology.",
                "finalsSubjects": [
                    "Clinical Psychology",
                    "Developmental Psychology",
                    "Counseling Techniques"
                ],
                "interests": [
                    "Child Psychology",
                    "Clinical Practice"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 90
                },
                "language": "Polish",
                "occupations": [
                    "Clinical Psychologist",
                    "Counselor"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Clinical Psychology": 0.4,
                        "Developmental Psychology": 0.4,
                        "Counseling Techniques": 0.2
                    },
                    "minThreshold": 80
                },
                "level": "Bachelor",
                "tuition": 3500,
                "earningsMedian": 5500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Introduction to Psychology",
                                "Research Methods"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Abnormal Psychology",
                                "Child Development"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Counseling Psychology",
                                "Clinical Practice"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Warsaw",
            "street": "Krakowskie Przedmieście",
            "buildingNumber": "26/28"
        },
        "coordinates": {
            "latitude": 52.2394,
            "longitude": 21.0151
        },
        "amenities": [
            {
                "name": "Student Cafeteria",
                "type": "RESTAURANT",
                "distance": 200
            },
            {
                "name": "Sports Facilities",
                "type": "RECREATION",
                "distance": 300
            },
            {
                "name": "Library",
                "type": "EDUCATIONAL",
                "distance": 150
            }
        ],
        "accessibilitiesForDisabled": [
            "Ramp",
            "Elevator",
            "Wheelchair Access",
            "Audio Description",
            "Braille Buttons"
        ],
        "clubs": [
            {
                "name": "Psychology Club",
                "description": "A student organization for psychology enthusiasts."
            },
            {
                "name": "Computer Science Club",
                "description": "A club for students passionate about computer science."
            }
        ],
        "siteURL": "https://www.uw.edu.pl/",
        "scholarships": [
            "Academic Excellence Scholarship",
            "Sports Scholarship"
        ]
    },
    {
        "name": "Politechnika Warszawska",
        "rating": 88.0,
        "photoUrl": "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Gmach_G%C5%82%C3%B3wny_Politechniki_Warszawskiej_2018.jpg/2560px-Gmach_G%C5%82%C3%B3wny_Politechniki_Warszawskiej_2018.jpg",
        "courseDegrees": [
            {
                "name": "Informatyka",
                "category": "ENGINEERING",
                "description": "Studia inżynierskie z informatyki.",
                "finalsSubjects": [
                    "Architektura komputerów",
                    "Inżynieria oprogramowania",
                    "Struktury danych"
                ],
                "interests": [
                    "Sztuczna inteligencja",
                    "Programowanie webowe"
                ],
                "occupancy": {
                    "noPlaces": 200,
                    "noCandidates": 160
                },
                "language": "Polski",
                "occupations": [
                    "Inżynier oprogramowania",
                    "Programista systemów wbudowanych"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Architektura komputerów": 0.4,
                        "Inżynieria oprogramowania": 0.4,
                        "Struktury danych": 0.2
                    },
                    "minThreshold": 75
                },
                "level": "Inżynierskie",
                "tuition": 4500,
                "earningsMedian": 6500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do informatyki",
                                "Elektronika cyfrowa"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Algorytmy i struktury danych",
                                "Sieci komputerowe"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Sztuczna inteligencja",
                                "Programowanie webowe"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Inżynieria mechaniczna",
                "category": "ENGINEERING",
                "description": "Studia inżynierskie z inżynierii mechanicznej.",
                "finalsSubjects": [
                    "Termodynamika",
                    "Projektowanie mechaniczne",
                    "Mechanika płynów"
                ],
                "interests": [
                    "Inżynieria samochodowa",
                    "Inżynieria lotnicza"
                ],
                "occupancy": {
                    "noPlaces": 180,
                    "noCandidates": 140
                },
                "language": "Polski",
                "occupations": [
                    "Inżynier mechanik",
                    "Inżynier lotniczy"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Termodynamika": 0.4,
                        "Projektowanie mechaniczne": 0.4,
                        "Mechanika płynów": 0.2
                    },
                    "minThreshold": 80
                },
                "level": "Inżynierskie",
                "tuition": 4200,
                "earningsMedian": 6800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Matematyka inżynierska",
                                "Wytrzymałość materiałów"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Kinematyka i dynamika",
                                "Termodynamika"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Aerodynamika",
                                "Projektowanie mechaniczne"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Warszawa",
            "street": "Plac Politechniki",
            "buildingNumber": "1"
        },
        "coordinates": {
            "latitude": 52.2209,
            "longitude": 21.0108
        },
        "amenities": [
            {
                "name": "Studencka kafeteria",
                "type": "RESTAURANT",
                "distance": 250
            },
            {
                "name": "Laboratoria inżynieryjne",
                "type": "EDUCATIONAL",
                "distance": 100
            },
            {
                "name": "Biblioteka",
                "type": "EDUCATIONAL",
                "distance": 180
            }
        ],
        "accessibilitiesForDisabled": [
            "Rampa",
            "Winda",
            "Dostęp dla wózków",
            "Opis dźwiękowy",
            "Przyciski Braille'a"
        ],
        "clubs": [
            {
                "name": "Koło Naukowe Informatyki",
                "description": "Organizacja studencka dla miłośników informatyki."
            },
            {
                "name": "Klub Inżynierski",
                "description": "Klub dla studentów pasjonujących się inżynierią."
            }
        ],
        "siteURL": "https://www.pw.edu.pl/",
        "scholarships": [
            "Stypendium za wyniki w nauce",
            "Stypendium inżynierskie"
        ]
    },
    {
        "name": "Politechnika Poznańska",
        "rating": 71.3,
        "photoUrl": "https://www.pomaturze.pl/pliki/galeria/PP-1_0.jpg",
        "courseDegrees": [
            {
                "name": "Informatyka",
                "category": "INFORMATION",
                "description": "Zdobądź wiedzę z zakresu informatyki i programowania.",
                "finalsSubjects": [
                    "Matematyka",
                    "Fizyka",
                    "Informatyka"
                ],
                "interests": [
                    "Programowanie",
                    "Sztuczna Inteligencja"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 100
                },
                "language": "Polski",
                "occupations": [
                    "Programista",
                    "Analityk Systemowy",
                    "Inżynier Oprogramowania"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 0.7,
                        "fizyka": 0.2,
                        "informatyka": 0.1
                    },
                    "minThreshold": 85
                },
                "level": "2",
                "tuition": 0,
                "earningsMedian": 7800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do programowania",
                                "Matematyka dyskretna"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Algorytmy i struktury danych",
                                "Programowanie obiektowe"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Bazy danych",
                                "Analiza i projektowanie systemów"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Inżynieria Elektryczna",
                "category": "ENGINEERING",
                "description": "Studiuj systemy elektryczne, elektronikę i telekomunikację.",
                "finalsSubjects": [
                    "Matematyka",
                    "Fizyka",
                    "Elektronika"
                ],
                "interests": [
                    "Energetyka",
                    "Telekomunikacja"
                ],
                "occupancy": {
                    "noPlaces": 150,
                    "noCandidates": 120
                },
                "language": "Polski",
                "occupations": [
                    "Inżynier Elektryk",
                    "Projektant Systemów Telekomunikacyjnych"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 0.6,
                        "fizyka": 0.4
                    },
                    "minThreshold": 80
                },
                "level": "2",
                "tuition": 0,
                "earningsMedian": 7500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy elektrotechniki",
                                "Matematyka dla inżynierów"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Fizyka techniczna",
                                "Układy elektroniczne"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Komunikacja cyfrowa",
                                "Systemy mikroprocesorowe"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Inżynieria Mechaniczna",
                "category": "ENGINEERING",
                "description": "Zdobądź wiedzę z zakresu mechaniki i projektowania systemów mechanicznych.",
                "finalsSubjects": [
                    "Matematyka",
                    "Fizyka",
                    "Informatyka"
                ],
                "interests": [
                    "Inżynieria Samochodowa",
                    "Konstrukcje Maszyn"
                ],
                "occupancy": {
                    "noPlaces": 180,
                    "noCandidates": 150
                },
                "language": "Polski",
                "occupations": [
                    "Inżynier Mechanik",
                    "Projektant Maszyn"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 0.5,
                        "fizyka": 0.4,
                        "informatyka": 0.1
                    },
                    "minThreshold": 75
                },
                "level": "3",
                "tuition": 0,
                "earningsMedian": 8000,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy mechaniki",
                                "Matematyka dla inżynierów"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Technologie materiałowe",
                                "Rysunek techniczny"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Modelowanie komputerowe",
                                "Inżynieria oprogramowania"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Poznań",
            "street": "plac Marii Skłodowskiej-Curie",
            "buildingNumber": "5"
        },
        "coordinates": {
            "latitude": 52.3941095,
            "longitude": 16.91838
        },
        "amenities": [
            {
                "name": "Stołówka Przysmak",
                "type": "RESTAURANT",
                "distance": 150
            },
            {
                "name": "Klub Studencki",
                "type": "RECREATION",
                "distance": 200
            },
            {
                "name": "Sklep Techniczny",
                "type": "SHOP",
                "distance": 180
            }
        ],
        "accessibilitiesForDisabled": [
            "Rampa",
            "Winda",
            "Schody Ruchome",
            "Audiodeskrypcja",
            "Przyciski Braille'a"
        ],
        "clubs": [
            {
                "name": "Koło Naukowe Informatyki",
                "description": "Dla pasjonatów programowania i informatyki."
            },
            {
                "name": "Klub Mechaników",
                "description": "Spotkania dla miłośników inżynierii mechanicznej."
            }
        ],
        "siteURL": "https://www.put.poznan.pl/",
        "scholarships": [
            "Stypendium za wyniki w nauce",
            "Stypendium sportowe"
        ]
    },
    {
        "name": "Uniwersytet Wrocławski",
        "rating": 69.4,
        "photoUrl": "https://uwr.edu.pl/wp-content/uploads/2018/10/UWr-grafiki-historia6.jpg",
        "courseDegrees": [
            {
                "name": "Psychologia",
                "category": "SOCIAL",
                "description": "Studia licencjackie z psychologii.",
                "finalsSubjects": [
                    "Psychologia kliniczna",
                    "Psychologia rozwojowa",
                    "Techniki terapeutyczne"
                ],
                "interests": [
                    "Psychologia dzieci i młodzieży",
                    "Psychoterapia"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 90
                },
                "language": "Polski",
                "occupations": [
                    "Psycholog kliniczny",
                    "Terapeuta"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Psychologia kliniczna": 0.4,
                        "Psychologia rozwojowa": 0.4,
                        "Techniki terapeutyczne": 0.2
                    },
                    "minThreshold": 80
                },
                "level": "Licencjackie",
                "tuition": 3500,
                "earningsMedian": 5500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do psychologii",
                                "Metodologia badań"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Psychologia osobowości",
                                "Psychologia dziecka"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Psychoterapia",
                                "Neuropsychologia"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Informatyka",
                "category": "SCIENCE",
                "description": "Studia inżynierskie z informatyki.",
                "finalsSubjects": [
                    "Bazy danych",
                    "Programowanie obiektowe",
                    "Sztuczna inteligencja"
                ],
                "interests": [
                    "Rozwój aplikacji mobilnych",
                    "Analiza danych"
                ],
                "occupancy": {
                    "noPlaces": 180,
                    "noCandidates": 150
                },
                "language": "Polski",
                "occupations": [
                    "Programista",
                    "Analityk danych"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Bazy danych": 0.4,
                        "Programowanie obiektowe": 0.4,
                        "Sztuczna inteligencja": 0.2
                    },
                    "minThreshold": 75
                },
                "level": "Inżynierskie",
                "tuition": 4200,
                "earningsMedian": 6500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy programowania",
                                "Bazy danych"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Programowanie obiektowe",
                                "Analiza danych"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Sztuczna inteligencja",
                                "Aplikacje mobilne"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Wrocław",
            "street": "ul. Uniwersytecka",
            "buildingNumber": "1"
        },
        "coordinates": {
            "latitude": 51.1089,
            "longitude": 17.0449
        },
        "amenities": [
            {
                "name": "Studencka kafeteria",
                "type": "RESTAURANT",
                "distance": 250
            },
            {
                "name": "Laboratoria informatyczne",
                "type": "EDUCATIONAL",
                "distance": 100
            },
            {
                "name": "Biblioteka",
                "type": "EDUCATIONAL",
                "distance": 180
            }
        ],
        "accessibilitiesForDisabled": [
            "Rampa",
            "Winda",
            "Dostęp dla wózków",
            "Opis dźwiękowy",
            "Przyciski Braille'a"
        ],
        "clubs": [
            {
                "name": "Koło Naukowe Psychologii",
                "description": "Organizacja studencka dla miłośników psychologii."
            },
            {
                "name": "Koło Naukowe Informatyki",
                "description": "Koło dla studentów pasjonujących się informatyką."
            }
        ],
        "siteURL": "https://www.uni.wroc.pl/",
        "scholarships": [
            "Stypendium za wyniki w nauce",
            "Stypendium naukowe"
        ]
    },
    {
        "name": "Uniwersytet im. Adama Mickiewicza w Poznaniu",
        "rating": 83.6,
        "photoUrl": "https://upload.wikimedia.org/wikipedia/commons/b/be/Collegium_Minus_w_Poznaniu.jpg",
        "courseDegrees": [
            {
                "name": "Psychologia",
                "category": "HUMANISTIC",
                "description": "Studia licencjackie z psychologii.",
                "finalsSubjects": [
                    "Psychologia kliniczna",
                    "Psychologia rozwojowa",
                    "Metody badawcze w psychologii"
                ],
                "interests": [
                    "Psychoterapia",
                    "Psychologia dziecka i młodzieży"
                ],
                "occupancy": {
                    "noPlaces": 150,
                    "noCandidates": 120
                },
                "language": "Polski",
                "occupations": [
                    "Psycholog kliniczny",
                    "Psychoterapeuta"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Psychologia kliniczna": 0.4,
                        "Psychologia rozwojowa": 0.4,
                        "Metody badawcze": 0.2
                    },
                    "minThreshold": 85
                },
                "level": "Licencjackie",
                "tuition": 3600,
                "earningsMedian": 5800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do psychologii",
                                "Statystyka"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Psychologia osobowości",
                                "Psychopatologia"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Psychoterapia",
                                "Psychologia dziecka"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Informatyka",
                "category": "SCIENCE",
                "description": "Studia inżynierskie z informatyki.",
                "finalsSubjects": [
                    "Bazy danych",
                    "Programowanie obiektowe",
                    "Sztuczna inteligencja"
                ],
                "interests": [
                    "Analiza danych",
                    "Bezpieczeństwo informatyczne"
                ],
                "occupancy": {
                    "noPlaces": 200,
                    "noCandidates": 160
                },
                "language": "Polski",
                "occupations": [
                    "Programista",
                    "Analityk danych"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Bazy danych": 0.4,
                        "Programowanie obiektowe": 0.4,
                        "Sztuczna inteligencja": 0.2
                    },
                    "minThreshold": 80
                },
                "level": "Inżynierskie",
                "tuition": 4500,
                "earningsMedian": 6800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy programowania",
                                "Bazy danych"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Programowanie obiektowe",
                                "Analiza danych"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Sztuczna inteligencja",
                                "Bezpieczeństwo informatyczne"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Poznań",
            "street": "ul. Wieniawskiego",
            "buildingNumber": "1"
        },
        "coordinates": {
            "latitude": 52.4105,
            "longitude": 16.8935
        },
        "amenities": [
            {
                "name": "Studencka kafeteria",
                "type": "RESTAURANT",
                "distance": 200
            },
            {
                "name": "Laboratoria informatyczne",
                "type": "EDUCATIONAL",
                "distance": 150
            },
            {
                "name": "Biblioteka",
                "type": "EDUCATIONAL",
                "distance": 180
            }
        ],
        "accessibilitiesForDisabled": [
            "Rampa",
            "Winda",
            "Dostęp dla wózków",
            "Opis dźwiękowy",
            "Przyciski Braille'a"
        ],
        "clubs": [
            {
                "name": "Koło Naukowe Psychologii",
                "description": "Organizacja studencka dla miłośników psychologii."
            },
            {
                "name": "Koło Naukowe Informatyki",
                "description": "Koło dla studentów pasjonujących się informatyką."
            }
        ],
        "siteURL": "https://www.amu.edu.pl/",
        "scholarships": [
            "Stypendium za wyniki w nauce",
            "Stypendium naukowe"
        ]
    },
    {
        "name": "Uniwersytet Warmińsko-Mazurski w Olsztynie",
        "rating": 56.7,
        "photoUrl": "https://bi.im-g.pl/im/f0/4d/15/z22337776AMP,Rektorat-UWM-w-Olsztynie.jpg",
        "courseDegrees": [
            {
                "name": "Biologia",
                "category": "NATURAL",
                "description": "Studiuj biologię na Uniwersytecie Warmińsko-Mazurskim.",
                "finalsSubjects": [
                    "Biologia Molekularna",
                    "Ekologia",
                    "Genetyka"
                ],
                "interests": [
                    "Badania nad Środowiskiem",
                    "Biotechnologia"
                ],
                "occupancy": {
                    "noPlaces": 100,
                    "noCandidates": 80
                },
                "language": "Polski",
                "occupations": [
                    "Biolog",
                    "Genetyk",
                    "Ekolog"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "biologia": 0.8,
                        "chemia": 0.2
                    },
                    "minThreshold": 75
                },
                "level": "2",
                "tuition": 0,
                "earningsMedian": 7000,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wstęp do biologii",
                                "Chemia organiczna"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Biologia komórki",
                                "Genetyka ogólna"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Biotechnologia",
                                "Ekologia"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Informatyka Stosowana",
                "category": "INFORMATION",
                "description": "Zdobądź wiedzę z zakresu informatyki na Uniwersytecie Warmińsko-Mazurskim.",
                "finalsSubjects": [
                    "Matematyka",
                    "Informatyka",
                    "Algorytmy"
                ],
                "interests": [
                    "Programowanie Aplikacji",
                    "Analiza Danych"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 100
                },
                "language": "Polski",
                "occupations": [
                    "Programista",
                    "Analityk Systemowy",
                    "Inżynier Oprogramowania"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 0.7,
                        "fizyka": 0.2,
                        "informatyka": 0.1
                    },
                    "minThreshold": 80
                },
                "level": "2",
                "tuition": 0,
                "earningsMedian": 7500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do programowania",
                                "Matematyka dyskretna"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Algorytmy i struktury danych",
                                "Programowanie obiektowe"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Bazy danych",
                                "Analiza i projektowanie systemów"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Zarządzanie Finansowe",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Studiuj zarządzanie finansami na Uniwersytecie Warmińsko-Mazurskim.",
                "finalsSubjects": [
                    "Rachunkowość",
                    "Finanse Przedsiębiorstw",
                    "Analiza Finansowa"
                ],
                "interests": [
                    "Zarządzanie Ryzykiem Finansowym",
                    "Konsulting Finansowy"
                ],
                "occupancy": {
                    "noPlaces": 80,
                    "noCandidates": 60
                },
                "language": "Polski",
                "occupations": [
                    "Analityk Finansowy",
                    "Konsultant ds. Finansów",
                    "Rachunkowy"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "matematyka": 0.6,
                        "ekonomia": 0.3,
                        "angielski": 0.1
                    },
                    "minThreshold": 70
                },
                "level": "1inz",
                "tuition": 0,
                "earningsMedian": 7200,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Rachunkowość finansowa",
                                "Matematyka finansowa"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Finanse przedsiębiorstw",
                                "Analiza finansowa"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Zarządzanie ryzykiem finansowym",
                                "Konsolidacja finansowa"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Olsztyn",
            "street": "Żołnierska",
            "buildingNumber": "45"
        },
        "coordinates": {
            "latitude": 53.778422,
            "longitude": 20.480220
        },
        "amenities": [
            {
                "name": "Nocny Klub Naukowy",
                "type": "EDUCATIONAL",
                "distance": 150
            },
            {
                "name": "Strefa Rekreacji",
                "type": "RECREATION",
                "distance": 200
            },
            {
                "name": "Kawiarnia Studencka",
                "type": "RESTAURANT",
                "distance": 180
            }
        ],
        "accessibilitiesForDisabled": [
            "Rampa",
            "Winda",
            "Schody Ruchome",
            "Audiodeskrypcja",
            "Przyciski Braille'a"
        ],
        "clubs": [
            {
                "name": "Koło Biologów",
                "description": "Spotkania i badania dla miłośników biologii."
            },
            {
                "name": "Klub Informatyków",
                "description": "Integracja i projekty z zakresu informatyki."
            }
        ],
        "siteURL": "https://uwm.edu.pl/",
        "scholarships": [
            "Stypendium zaangażowania społecznego",
            "Stypendium dla najlepszych studentów"
        ]
    },
    {
        "name": "Uniwersytet Łódzki",
        "rating": 62.0,
        "photoUrl": "https://upload.wikimedia.org/wikipedia/commons/5/53/%C5%81%C3%B3d%C5%BA%2C_Uniwersytet_%C5%81%C3%B3dzki_Rektorat_Uniwersytetu_%C5%81%C3%B3dzkiego_-_nowy_-_panoramio_%281%29.jpg",
        "courseDegrees": [
            {
                "name": "Psychologia",
                "category": "SOCIAL",
                "description": "Studia licencjackie z psychologii.",
                "finalsSubjects": [
                    "Psychologia kliniczna",
                    "Psychologia rozwojowa",
                    "Metody badawcze w psychologii"
                ],
                "interests": [
                    "Psychoterapia",
                    "Psychologia dziecka i młodzieży"
                ],
                "occupancy": {
                    "noPlaces": 150,
                    "noCandidates": 120
                },
                "language": "Polski",
                "occupations": [
                    "Psycholog kliniczny",
                    "Psychoterapeuta"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Psychologia kliniczna": 0.4,
                        "Psychologia rozwojowa": 0.4,
                        "Metody badawcze": 0.2
                    },
                    "minThreshold": 85
                },
                "level": "Licencjackie",
                "tuition": 3600,
                "earningsMedian": 5800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do psychologii",
                                "Statystyka"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Psychologia osobowości",
                                "Psychopatologia"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Psychoterapia",
                                "Psychologia dziecka"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Informatyka",
                "category": "SCIENCE",
                "description": "Studia inżynierskie z informatyki.",
                "finalsSubjects": [
                    "Bazy danych",
                    "Programowanie obiektowe",
                    "Sztuczna inteligencja"
                ],
                "interests": [
                    "Analiza danych",
                    "Bezpieczeństwo informatyczne"
                ],
                "occupancy": {
                    "noPlaces": 200,
                    "noCandidates": 160
                },
                "language": "Polski",
                "occupations": [
                    "Programista",
                    "Analityk danych"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Bazy danych": 0.4,
                        "Programowanie obiektowe": 0.4,
                        "Sztuczna inteligencja": 0.2
                    },
                    "minThreshold": 80
                },
                "level": "Inżynierskie",
                "tuition": 4500,
                "earningsMedian": 6800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy programowania",
                                "Bazy danych"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Programowanie obiektowe",
                                "Analiza danych"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Sztuczna inteligencja",
                                "Bezpieczeństwo informatyczne"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Filologia Angielska",
                "category": "HUMANISTIC",
                "description": "Studia licencjackie z filologii angielskiej.",
                "finalsSubjects": [
                    "Gramatyka angielska",
                    "Literatura angielska",
                    "Tłumaczenie literatury"
                ],
                "interests": [
                    "Lingwistyka stosowana",
                    "Tłumaczenia specjalistyczne"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 100
                },
                "language": "Polski",
                "occupations": [
                    "Tłumacz",
                    "Nauczyciel języka angielskiego"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Gramatyka angielska": 0.4,
                        "Literatura angielska": 0.4,
                        "Tłumaczenie literatury": 0.2
                    },
                    "minThreshold": 85
                },
                "level": "Licencjackie",
                "tuition": 3500,
                "earningsMedian": 6000,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do filologii angielskiej",
                                "Gramatyka angielska"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Literatura angielska",
                                "Historia języka angielskiego"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Tłumaczenie literatury",
                                "Lingwistyka stosowana"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Łódź",
            "street": "ul. Pomorska",
            "buildingNumber": "171/173"
        },
        "coordinates": {
            "latitude": 51.7482,
            "longitude": 19.4499
        },
        "amenities": [
            {
                "name": "Studencka kafeteria",
                "type": "RESTAURANT",
                "distance": 200
            },
            {
                "name": "Laboratoria komputerowe",
                "type": "EDUCATIONAL",
                "distance": 150
            },
            {
                "name": "Biblioteka",
                "type": "EDUCATIONAL",
                "distance": 180
            }
        ],
        "accessibilitiesForDisabled": [
            "Rampa",
            "Winda",
            "Dostęp dla wózków",
            "Opis dźwiękowy",
            "Przyciski Braille'a"
        ],
        "clubs": [
            {
                "name": "Koło Naukowe Psychologii",
                "description": "Organizacja studencka dla miłośników psychologii."
            },
            {
                "name": "Koło Naukowe Informatyki",
                "description": "Koło dla studentów pasjonujących się informatyką."
            },
            {
                "name": "Koło Naukowe Filologii Angielskiej",
                "description": "Organizacja studencka dla miłośników języka angielskiego."
            }
        ],
        "siteURL": "https://www.uni.lodz.pl/",
        "scholarships": [
            "Stypendium za wyniki w nauce",
            "Stypendium naukowe"
        ]
    }

]""".trimIndent()