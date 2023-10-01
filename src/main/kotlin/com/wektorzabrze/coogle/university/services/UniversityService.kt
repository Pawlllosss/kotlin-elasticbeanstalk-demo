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
    },
    {
        "name": "Uniwersytet Rzeszowski",
        "rating": "35.7",
        "photoUrl": "https://bi.im-g.pl/im/2c/c3/1a/z28063532AMP,Uniwersytet-Rzeszowski.jpg",
        "courseDegrees": [
            {
                "name": "Psychologia Społeczna",
                "category": "SOCIAL",
                "description": "Studiuj psychologię społeczną na Uniwersytecie Rzeszowskim.",
                "finalsSubjects": [
                    "Psychologia Społeczna",
                    "Statystyka w Psychologii",
                    "Psychoterapia"
                ],
                "interests": [
                    "Psychologia Organizacyjna",
                    "Badania Społeczne"
                ],
                "occupancy": {
                    "noPlaces": 90,
                    "noCandidates": 75
                },
                "language": "Polski",
                "occupations": [
                    "Psycholog Społeczny",
                    "Konsultant ds. Zasobów Ludzkich",
                    "Badacz Społeczny"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "psychologia": 0.7,
                        "statystyka": 0.2,
                        "angielski": 0.1
                    },
                    "minThreshold": 75
                },
                "level": "2",
                "tuition": 1000,
                "earningsMedian": 6800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do psychologii",
                                "Podstawy statystyki"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Psychologia społeczna",
                                "Psychologia pracy"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Psychoterapia",
                                "Badania społeczne"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Inżynieria Materiałowa",
                "category": "ENGINEERING",
                "description": "Zdobądź wiedzę z zakresu inżynierii materiałowej na Uniwersytecie Rzeszowskim.",
                "finalsSubjects": [
                    "Chemia Ogólna",
                    "Materiałoznawstwo",
                    "Inżynieria Powierzchni"
                ],
                "interests": [
                    "Technologie Materiałowe",
                    "Badania Strukturalne"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 100
                },
                "language": "Polski",
                "occupations": [
                    "Inżynier Materiałowy",
                    "Specjalista ds. Badań Materiałowych",
                    "Technolog"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "chemia": 0.6,
                        "matematyka": 0.3,
                        "fizyka": 0.1
                    },
                    "minThreshold": 70
                },
                "level": "1inz",
                "tuition": 1500,
                "earningsMedian": 7800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Chemia ogólna",
                                "Matematyka"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Materiałoznawstwo",
                                "Podstawy fizyki"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Inżynieria powierzchni",
                                "Technologie materiałowe"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Zarządzanie Projektem",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Studiuj zarządzanie projektami na Uniwersytecie Rzeszowskim.",
                "finalsSubjects": [
                    "Zarządzanie Projektami",
                    "Rachunkowość Zarządcza",
                    "Negocjacje Biznesowe"
                ],
                "interests": [
                    "Scrum",
                    "Zarządzanie Ryzykiem Projektowym"
                ],
                "occupancy": {
                    "noPlaces": 80,
                    "noCandidates": 60
                },
                "language": "Polski",
                "occupations": [
                    "Kierownik Projektu",
                    "Specjalista ds. Zarządzania Projektami",
                    "Analityk Biznesowy"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "zarządzanie_projektami": 0.7,
                        "rachunkowość": 0.2,
                        "angielski": 0.1
                    },
                    "minThreshold": 75
                },
                "level": "2",
                "tuition": 1200,
                "earningsMedian": 7500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Zarządzanie projektami",
                                "Rachunkowość zarządcza"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Negocjacje biznesowe",
                                "Zarządzanie ryzykiem projektowym"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Techniki prezentacji",
                                "Zarządzanie czasem"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Rzeszów",
            "street": "Akademicka",
            "buildingNumber": "27"
        },
        "coordinates": {
            "latitude": 50.035167,
            "longitude": 21.968667
        },
        "amenities": [
            {
                "name": "Klub Filmowy",
                "type": "RECREATION",
                "distance": 250
            },
            {
                "name": "Siłownia Uniwersytecka",
                "type": "RECREATION",
                "distance": 180
            },
            {
                "name": "Sala Konferencyjna",
                "type": "EDUCATIONAL",
                "distance": 300
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
                "name": "Koło Psychologów",
                "description": "Spotkania i badania dla studentów psychologii."
            },
            {
                "name": "Klub Inżynierów Materiałowych",
                "description": "Integracja i projekty z zakresu inżynierii materiałowej."
            }
        ],
        "siteURL": "https://www.ur.edu.pl/pl/",
        "scholarships": [
            "Stypendium zaangażowania społecznego",
            "Stypendium dla uzdolnionych"
        ]
    },
    {
        "name": "Uniwersytet Śląski",
        "rating": 61.0,
        "photoUrl": "https://www.wkatowicach.eu/assets/pics/aktualnosci/2022-11/U%C5%9A.jpg",
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
                "name": "Biologia",
                "category": "SCIENCE",
                "description": "Studia licencjackie z biologii.",
                "finalsSubjects": [
                    "Biologia molekularna",
                    "Ekologia",
                    "Zoologia"
                ],
                "interests": [
                    "Ochrona środowiska",
                    "Genetyka"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 100
                },
                "language": "Polski",
                "occupations": [
                    "Biolog",
                    "Ekolog"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Biologia molekularna": 0.4,
                        "Ekologia": 0.4,
                        "Zoologia": 0.2
                    },
                    "minThreshold": 80
                },
                "level": "Licencjackie",
                "tuition": 3500,
                "earningsMedian": 6200,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy biologii",
                                "Biologia komórki"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Biologia molekularna",
                                "Ekologia"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Zoologia",
                                "Ochrona środowiska"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Ekonomia",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Studia magisterskie z ekonomii.",
                "finalsSubjects": [
                    "Mikroekonomia",
                    "Makroekonomia",
                    "Finanse publiczne"
                ],
                "interests": [
                    "Polityka gospodarcza",
                    "Rachunkowość"
                ],
                "occupancy": {
                    "noPlaces": 180,
                    "noCandidates": 150
                },
                "language": "Polski",
                "occupations": [
                    "Ekonomista",
                    "Analityk finansowy"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Mikroekonomia": 0.4,
                        "Makroekonomia": 0.4,
                        "Finanse publiczne": 0.2
                    },
                    "minThreshold": 85
                },
                "level": "Magisterskie",
                "tuition": 4000,
                "earningsMedian": 7200,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do ekonomii",
                                "Mikroekonomia"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Makroekonomia",
                                "Finanse publiczne"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Polityka gospodarcza",
                                "Rachunkowość"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Medycyna",
                "category": "MEDICINE",
                "description": "Studia magisterskie z medycyny.",
                "finalsSubjects": [
                    "Anatomia",
                    "Farmakologia",
                    "Chirurgia"
                ],
                "interests": [
                    "Pediatria",
                    "Kardiologia"
                ],
                "occupancy": {
                    "noPlaces": 200,
                    "noCandidates": 180
                },
                "language": "Polski",
                "occupations": [
                    "Lekarz",
                    "Specjalista ds. Chirurgii"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Anatomia": 0.4,
                        "Farmakologia": 0.4,
                        "Chirurgia": 0.2
                    },
                    "minThreshold": 90
                },
                "level": "Magisterskie",
                "tuition": 5500,
                "earningsMedian": 8500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Anatomia",
                                "Biochemia"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Farmakologia",
                                "Pediatria"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Chirurgia",
                                "Kardiologia"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Katowice",
            "street": "ul. Bankowa",
            "buildingNumber": "11"
        },
        "coordinates": {
            "latitude": 50.2584,
            "longitude": 19.0276
        },
        "amenities": [
            {
                "name": "Studencka kafeteria",
                "type": "RESTAURANT",
                "distance": 200
            },
            {
                "name": "Laboratoria naukowe",
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
                "name": "Koło Naukowe Biologii",
                "description": "Organizacja studencka dla miłośników biologii."
            },
            {
                "name": "Koło Naukowe Ekonomii",
                "description": "Koło dla przyszłych ekonomistów."
            },
            {
                "name": "Koło Naukowe Medycyny",
                "description": "Organizacja studencka dla przyszłych lekarzy."
            }
        ],
        "siteURL": "https://www.us.edu.pl/",
        "scholarships": [
            "Stypendium za wyniki w nauce",
            "Stypendium naukowe"
        ]
    },
    {
        "name": "Uniwersytet Kazimierza Wielkiego w Bydgoszczy",
        "rating": "26.2",
        "photoUrl": "https://d-art.ppstatic.pl/kadry/k/r/1/d8/ad/6130903918b60_o_full.jpg",
        "courseDegrees": [
            {
                "name": "Informatyka Stosowana",
                "category": "INFORMATION",
                "description": "Zdobądź praktyczne umiejętności informatyczne na Uniwersytecie Kazimierza Wielkiego.",
                "finalsSubjects": [
                    "Programowanie Obiektowe",
                    "Bazy Danych",
                    "Analiza Systemów Informatycznych"
                ],
                "interests": [
                    "Tworzenie Aplikacji Mobilnych",
                    "Sztuczna Inteligencja"
                ],
                "occupancy": {
                    "noPlaces": 100,
                    "noCandidates": 80
                },
                "language": "Polski",
                "occupations": [
                    "Programista",
                    "Administrator Baz Danych",
                    "Specjalista ds. Bezpieczeństwa IT"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "programowanie_obiektowe": 0.7,
                        "matematyka": 0.2,
                        "angielski": 0.1
                    },
                    "minThreshold": 85
                },
                "level": "2",
                "tuition": 1200,
                "earningsMedian": 7800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do informatyki",
                                "Podstawy programowania"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Struktury danych",
                                "Bazy danych"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Programowanie obiektowe",
                                "Analiza systemów informatycznych"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Biotechnologia",
                "category": "SCIENCE",
                "description": "Studiuj biotechnologię na Uniwersytecie Kazimierza Wielkiego.",
                "finalsSubjects": [
                    "Biochemia",
                    "Genetyka",
                    "Inżynieria Genetyczna"
                ],
                "interests": [
                    "Biologia Molekularna",
                    "Produkcja Leków"
                ],
                "occupancy": {
                    "noPlaces": 80,
                    "noCandidates": 60
                },
                "language": "Polski",
                "occupations": [
                    "Biotechnolog",
                    "Analityk Genetyczny",
                    "Specjalista ds. Badań Klinicznych"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "biochemia": 0.6,
                        "chemia": 0.3,
                        "biologia": 0.1
                    },
                    "minThreshold": 78
                },
                "level": "1inz",
                "tuition": 1500,
                "earningsMedian": 7600,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Biochemia",
                                "Chemia organiczna"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Genetyka",
                                "Biologia molekularna"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Inżynieria genetyczna",
                                "Metody badań biotechnologicznych"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Zarządzanie Kulturą",
                "category": "ARTS",
                "description": "Zajmuj się zarządzaniem kulturą na Uniwersytecie Kazimierza Wielkiego.",
                "finalsSubjects": [
                    "Teoria Kultury",
                    "Event Management",
                    "Public Relations w Kulturze"
                ],
                "interests": [
                    "Organizacja Wydarzeń Kulturalnych",
                    "Marketing Kultury"
                ],
                "occupancy": {
                    "noPlaces": 70,
                    "noCandidates": 50
                },
                "language": "Polski",
                "occupations": [
                    "Menadżer Kultury",
                    "Specjalista ds. Promocji Kultury",
                    "Kurator Wystaw"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "teoria_kultury": 0.7,
                        "angielski": 0.2,
                        "historia_sztuki": 0.1
                    },
                    "minThreshold": 80
                },
                "level": "2",
                "tuition": 1300,
                "earningsMedian": 7200,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Teoria kultury",
                                "Historia sztuki"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Event management",
                                "Public relations w kulturze"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Marketing kultury",
                                "Organizacja wydarzeń kulturalnych"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Bydgoszcz",
            "street": "Nowotoruńska",
            "buildingNumber": "9"
        },
        "coordinates": {
            "latitude": 53.116667,
            "longitude": 18.0
        },
        "amenities": [
            {
                "name": "Galeria Sztuki",
                "type": "RECREATION",
                "distance": 200
            },
            {
                "name": "Klub Literacki",
                "type": "RECREATION",
                "distance": 150
            },
            {
                "name": "Sala Koncertowa",
                "type": "RECREATION",
                "distance": 300
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
                "name": "Koło Informatyków",
                "description": "Integracja i projekty informatyczne dla studentów."
            },
            {
                "name": "Teatr Studencki",
                "description": "Grupa teatralna działająca przy uczelni."
            }
        ],
        "siteURL": "https://www.ukw.edu.pl/",
        "scholarships": [
            "Stypendium za wyniki w nauce",
            "Stypendium sportowe"
        ]
    },
    {
        "name": "Uniwersytet Opolski",
        "rating": 64.0,
        "photoUrl": "https://www.uni.opole.pl/uploads/news/770/2019-06-27-093042.jpg",
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
                "category": "ENGINEERING",
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
                "name": "Biologia",
                "category": "NATURAL",
                "description": "Studia licencjackie z biologii.",
                "finalsSubjects": [
                    "Biologia molekularna",
                    "Ekologia",
                    "Zoologia"
                ],
                "interests": [
                    "Ochrona środowiska",
                    "Genetyka"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 100
                },
                "language": "Polski",
                "occupations": [
                    "Biolog",
                    "Ekolog"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Biologia molekularna": 0.4,
                        "Ekologia": 0.4,
                        "Zoologia": 0.2
                    },
                    "minThreshold": 80
                },
                "level": "Licencjackie",
                "tuition": 3500,
                "earningsMedian": 6200,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Podstawy biologii",
                                "Biologia komórki"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Biologia molekularna",
                                "Ekologia"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Zoologia",
                                "Ochrona środowiska"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Prawo",
                "category": "SOCIAL",
                "description": "Studia magisterskie z prawa.",
                "finalsSubjects": [
                    "Prawo cywilne",
                    "Prawo konstytucyjne",
                    "Prawo międzynarodowe"
                ],
                "interests": [
                    "Prawo gospodarcze",
                    "Prawo międzynarodowe"
                ],
                "occupancy": {
                    "noPlaces": 180,
                    "noCandidates": 150
                },
                "language": "Polski",
                "occupations": [
                    "Adwokat",
                    "Sędzia"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Prawo cywilne": 0.4,
                        "Prawo konstytucyjne": 0.4,
                        "Prawo międzynarodowe": 0.2
                    },
                    "minThreshold": 85
                },
                "level": "Magisterskie",
                "tuition": 3800,
                "earningsMedian": 7200,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do prawa",
                                "Prawo cywilne"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Prawo konstytucyjne",
                                "Prawo administracyjne"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Prawo gospodarcze",
                                "Prawo międzynarodowe"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Ekonomia",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Studia magisterskie z ekonomii.",
                "finalsSubjects": [
                    "Mikroekonomia",
                    "Makroekonomia",
                    "Finanse publiczne"
                ],
                "interests": [
                    "Polityka gospodarcza",
                    "Rachunkowość"
                ],
                "occupancy": {
                    "noPlaces": 180,
                    "noCandidates": 150
                },
                "language": "Polski",
                "occupations": [
                    "Ekonomista",
                    "Analityk finansowy"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Mikroekonomia": 0.4,
                        "Makroekonomia": 0.4,
                        "Finanse publiczne": 0.2
                    },
                    "minThreshold": 85
                },
                "level": "Magisterskie",
                "tuition": 4000,
                "earningsMedian": 7200,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do ekonomii",
                                "Mikroekonomia"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Makroekonomia",
                                "Finanse publiczne"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Polityka gospodarcza",
                                "Rachunkowość"
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
                    "Literatura angielska",
                    "Lingwistyka",
                    "Kultura brytyjska"
                ],
                "interests": [
                    "Tłumaczenia",
                    "Nauczanie języka angielskiego"
                ],
                "occupancy": {
                    "noPlaces": 100,
                    "noCandidates": 80
                },
                "language": "Polski",
                "occupations": [
                    "Tłumacz",
                    "Nauczyciel języka angielskiego"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Literatura angielska": 0.4,
                        "Lingwistyka": 0.4,
                        "Kultura brytyjska": 0.2
                    },
                    "minThreshold": 80
                },
                "level": "Licencjackie",
                "tuition": 3500,
                "earningsMedian": 6200,
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
                                "Lingwistyka"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Kultura brytyjska",
                                "Tłumaczenia"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Historia",
                "category": "HUMANISTIC",
                "description": "Studia magisterskie z historii.",
                "finalsSubjects": [
                    "Historia Polski",
                    "Historia Europy",
                    "Historiografia"
                ],
                "interests": [
                    "Archeologia",
                    "Muzeologia"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 100
                },
                "language": "Polski",
                "occupations": [
                    "Historyk",
                    "Archeolog"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Historia Polski": 0.4,
                        "Historia Europy": 0.4,
                        "Historiografia": 0.2
                    },
                    "minThreshold": 85
                },
                "level": "Magisterskie",
                "tuition": 3800,
                "earningsMedian": 6700,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do historii",
                                "Historia Polski"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Historia Europy",
                                "Historia sztuki"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Historiografia",
                                "Archeologia"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Opole",
            "street": "ul. Uniwersytecka",
            "buildingNumber": "7"
        },
        "coordinates": {
            "latitude": 50.6667,
            "longitude": 17.9301
        },
        "amenities": [
            {
                "name": "Studencka kafeteria",
                "type": "RESTAURANT",
                "distance": 200
            },
            {
                "name": "Laboratoria naukowe",
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
            "Opis dźżewiękowy",
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
                "name": "Koło Naukowe Biologii",
                "description": "Organizacja studencka dla miłośników biologii."
            },
            {
                "name": "Koło Naukowe Prawa",
                "description": "Koło dla przyszłych prawników."
            },
            {
                "name": "Koło Naukowe Historii",
                "description": "Organizacja studencka dla miłośników historii."
            }
        ],
        "siteURL": "https://www.uni.opole.pl/",
        "scholarships": [
            "Stypendium za wyniki w nauce",
            "Stypendium socjalne"
        ]
    },
    {
        "name": "Uniwersytet Marii Curie-Skłodowskiej w Lublinie",
        "rating": 55.0,
        "photoUrl": "https://pliki.portalsamorzadowy.pl/i/20/26/92/202692_r0_940.jpg",
        "courseDegrees": [
            {
                "name": "Psychologia",
                "category": "SOCIAL",
                "description": "Studiuj psychologię na Uniwersytecie Marii Curie-Skłodowskiej.",
                "finalsSubjects": [
                    "Psychologia Ogólna",
                    "Psychologia Kliniczna",
                    "Neuropsychologia"
                ],
                "interests": [
                    "Psychoterapia",
                    "Badania Nad mózgiem"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 100
                },
                "language": "Polski",
                "occupations": [
                    "Psycholog Kliniczny",
                    "Terapeuta Psychodynamiczny",
                    "Badacz Neuropsychologii"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "psychologia_ogolna": 0.6,
                        "biologia": 0.2,
                        "angielski": 0.2
                    },
                    "minThreshold": 88
                },
                "level": "2",
                "tuition": 1800,
                "earningsMedian": 8200,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do psychologii",
                                "Psychologia ogólna"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Neuropsychologia",
                                "Statystyka w psychologii"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Psychoterapia",
                                "Psychologia kliniczna"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Chemia Materiałów",
                "category": "SCIENCE",
                "description": "Zajmuj się chemią materiałów na Uniwersytecie Marii Curie-Skłodowskiej.",
                "finalsSubjects": [
                    "Chemia Analityczna",
                    "Chemia Fizyczna",
                    "Technologie Chemiczne"
                ],
                "interests": [
                    "Synteza Materiałów",
                    "Badania Struktury Chemicznej"
                ],
                "occupancy": {
                    "noPlaces": 80,
                    "noCandidates": 60
                },
                "language": "Polski",
                "occupations": [
                    "Chemiczka Materiałowa",
                    "Analityk Chemiczny",
                    "Inżynier Procesu Chemicznego"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "chemia_analityczna": 0.5,
                        "fizyka": 0.3,
                        "angielski": 0.2
                    },
                    "minThreshold": 75
                },
                "level": "1inz",
                "tuition": 1600,
                "earningsMedian": 7800,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Chemia analityczna",
                                "Matematyka w chemii"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Chemia fizyczna",
                                "Technologie chemiczne"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Chemia materiałów",
                                "Spektroskopia"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Dziennikarstwo i Komunikacja Społeczna",
                "category": "HUMANISTIC",
                "description": "Studiuj dziennikarstwo na Uniwersytecie Marii Curie-Skłodowskiej.",
                "finalsSubjects": [
                    "Teoria Komunikacji Społecznej",
                    "Dziennikarstwo Śledcze",
                    "Media Społecznościowe"
                ],
                "interests": [
                    "Dziennikarstwo Śledcze",
                    "Nowe Media"
                ],
                "occupancy": {
                    "noPlaces": 100,
                    "noCandidates": 80
                },
                "language": "Polski",
                "occupations": [
                    "Dziennikarz Śledczy",
                    "Specjalista ds. Social Media",
                    "Redaktor Gazety"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "teoria_komunikacji": 0.6,
                        "angielski": 0.2,
                        "historia": 0.2
                    },
                    "minThreshold": 82
                },
                "level": "2",
                "tuition": 1500,
                "earningsMedian": 7500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Teoria komunikacji społecznej",
                                "Historia dziennikarstwa"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Dziennikarstwo śledcze",
                                "Media społecznościowe"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Kultura audiowizualna",
                                "Etyka dziennikarska"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PUBLIC",
        "address": {
            "city": "Lublin",
            "street": "Marii Curie-Skłodowskiej",
            "buildingNumber": "5"
        },
        "coordinates": {
            "latitude": 51.2455041,
            "longitude": 22.5408742
        },
        "amenities": [
            {
                "name": "Teatr Uniwersytecki",
                "type": "RECREATION",
                "distance": 200
            },
            {
                "name": "Klub Literacki",
                "type": "EDUCATIONAL",
                "distance": 150
            },
            {
                "name": "Stołówka Studencka",
                "type": "RESTAURANT",
                "distance": 300
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
                "name": "Koło Psychologów",
                "description": "Spotkania i dyskusje na tematy psychologiczne."
            },
            {
                "name": "Studio Radiowe",
                "description": "Tworzenie i nadawanie programów radiowych."
            }
        ],
        "siteURL": "https://www.umcs.pl/",
        "scholarships": [
            "Stypendium naukowe",
            "Stypendium zaangażowania społecznego"
        ]
    },
    {
        "name": "Akademia Leona Koźmińskiego w Warszawie",
        "rating": 100.0,
        "photoUrl": "https://gfx.dlastudenta.pl/fotoalbum/48c/34c/b86/aa8/1163169",
        "courseDegrees": [
            {
                "stationary": false,
                "name": "Zarządzanie",
                "category": "SOCIAL",
                "description": "Studia licencjackie z zarządzania.",
                "finalsSubjects": [
                    "Zarządzanie strategiczne",
                    "Marketing",
                    "Finanse"
                ],
                "interests": [
                    "Zarządzanie projektami",
                    "Marketing internetowy"
                ],
                "occupancy": {
                    "noPlaces": 200,
                    "noCandidates": 180
                },
                "language": "Polski",
                "occupations": [
                    "Kierownik działu marketingu",
                    "Specjalista ds. zarządzania"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Zarządzanie strategiczne": 0.4,
                        "Marketing": 0.4,
                        "Finanse": 0.2
                    },
                    "minThreshold": 85
                },
                "level": "Licencjackie",
                "tuition": 3800,
                "earningsMedian": 6500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do zarządzania",
                                "Podstawy marketingu"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Zarządzanie strategiczne",
                                "Marketing internetowy"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Finanse",
                                "Zarządzanie projektami"
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
                    "minThreshold": 85
                },
                "level": "Inżynierskie",
                "tuition": 4200,
                "earningsMedian": 7000,
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
                "name": "Psychologia",
                "category": "SOCIAL",
                "description": "Studia magisterskie z psychologii.",
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
                    "minThreshold": 90
                },
                "level": "Magisterskie",
                "tuition": 4800,
                "earningsMedian": 7500,
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
                "name": "Finanse i rachunkowość",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Studia licencjackie z finansów i rachunkowości.",
                "finalsSubjects": [
                    "Rachunkowość finansowa",
                    "Finanse przedsiębiorstw",
                    "Podatki"
                ],
                "interests": [
                    "Audyt",
                    "Controlling"
                ],
                "occupancy": {
                    "noPlaces": 200,
                    "noCandidates": 160
                },
                "language": "Polski",
                "occupations": [
                    "Analityk finansowy",
                    "Księgowy"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Rachunkowość finansowa": 0.4,
                        "Finanse przedsiębiorstw": 0.4,
                        "Podatki": 0.2
                    },
                    "minThreshold": 85
                },
                "level": "Licencjackie",
                "tuition": 3800,
                "earningsMedian": 6700,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do rachunkowości",
                                "Finanse przedsiębiorstw"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Rachunkowość finansowa",
                                "Podatki"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Audyt",
                                "Controlling"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Międzynarodowe stosunki gospodarcze",
                "category": "SOCIAL",
                "description": "Studia magisterskie z międzynarodowych stosunków gospodarczych.",
                "finalsSubjects": [
                    "Handel międzynarodowy",
                    "Polityka handlowa",
                    "Ekonomiczne aspekty globalizacji"
                ],
                "interests": [
                    "Dyplomacja gospodarcza",
                    "Analiza rynków zagranicznych"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 100
                },
                "language": "Polski",
                "occupations": [
                    "Analityk ds. handlu zagranicznego",
                    "Dyplomata gospodarczy"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Handel międzynarodowy": 0.4,
                        "Polityka handlowa": 0.4,
                        "Globalizacja": 0.2
                    },
                    "minThreshold": 90
                },
                "level": "Magisterskie",
                "tuition": 4600,
                "earningsMedian": 7200,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do stosunków międzynarodowych",
                                "Handel międzynarodowy"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Polityka handlowa",
                                "Ekonomiczne aspekty globalizacji"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Dyplomacja gospodarcza",
                                "Analiza rynków zagranicznych"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Medycyna",
                "category": "MEDICINE",
                "description": "Studia magisterskie z medycyny.",
                "finalsSubjects": [
                    "Anatomia",
                    "Farmakologia",
                    "Chirurgia"
                ],
                "interests": [
                    "Chirurgia plastyczna",
                    "Pediatria"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 100
                },
                "language": "Polski",
                "occupations": [
                    "Lekarz",
                    "Chirurg"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Anatomia": 0.4,
                        "Farmakologia": 0.4,
                        "Chirurgia": 0.2
                    },
                    "minThreshold": 95
                },
                "level": "Magisterskie",
                "tuition": 5500,
                "earningsMedian": 9000,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Anatomia",
                                "Biologia"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Farmakologia",
                                "Chirurgia"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Chirurgia plastyczna",
                                "Pediatria"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PRIVATE",
        "address": {
            "city": "Warszawa",
            "street": "ul. Jagiellońska",
            "buildingNumber": "57"
        },
        "coordinates": {
            "latitude": 52.2716294,
            "longitude": 21.0144583
        },
        "amenities": [
            {
                "name": "Studencka kawiarnia",
                "type": "RESTAURANT",
                "distance": 100
            },
            {
                "name": "Biblioteka uniwersytecka",
                "type": "EDUCATIONAL",
                "distance": 150
            },
            {
                "name": "Klub studencki",
                "type": "RECREATION",
                "distance": 200
            }
        ],
        "accessibilitiesForDisabled": [
            "Winda",
            "Dostęp dla wózków",
            "Opis dźwiękowy",
            "Przyciski Braille'a"
        ],
        "clubs": [
            {
                "name": "Koło Naukowe Zarządzania",
                "description": "Organizacja studencka dla miłośników zarządzania."
            },
            {
                "name": "Koło Naukowe Informatyki",
                "description": "Koło dla studentów pasjonujących się informatyką."
            },
            {
                "name": "Koło Naukowe Psychologii",
                "description": "Organizacja studencka dla miłośników psychologii."
            },
            {
                "name": "Koło Naukowe Medyczne",
                "description": "Koło dla studentów kierunku medycyna."
            },
            {
                "name": "Koło Naukowe Ekonomii",
                "description": "Organizacja studencka dla miłośników ekonomii."
            }
        ],
        "siteURL": "https://www.kozminski.edu.pl/",
        "scholarships": [
            "Stypendium za wyniki w nauce",
            "Stypendium sportowe"
        ]
    },
    {
        "name": "Akademia WSB w Dąbrowie Górniczej",
        "rating": 75.6,
        "photoUrl": "https://www.otouczelnie.pl/assets/uploads/artykul%20kierunek/akademia-wsb.jpg",
        "courseDegrees": [
            {
                "stationary": false,
                "name": "Informatyka",
                "category": "SCIENCE",
                "description": "Studia inżynierskie z informatyki.",
                "finalsSubjects": [
                    "Programowanie",
                    "Bazy danych",
                    "Sztuczna inteligencja"
                ],
                "interests": [
                    "Analiza danych",
                    "Bezpieczeństwo informatyczne"
                ],
                "occupancy": {
                    "noPlaces": 150,
                    "noCandidates": 120
                },
                "language": "Polski",
                "occupations": [
                    "Programista",
                    "Analityk danych"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Programowanie": 0.4,
                        "Bazy danych": 0.4,
                        "Sztuczna inteligencja": 0.2
                    },
                    "minThreshold": 85
                },
                "level": "Inżynierskie",
                "tuition": 4200,
                "earningsMedian": 7000,
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
                "name": "Psychologia",
                "category": "SOCIAL",
                "description": "Studia magisterskie z psychologii.",
                "finalsSubjects": [
                    "Psychoterapia",
                    "Psychologia kliniczna",
                    "Metody badawcze w psychologii"
                ],
                "interests": [
                    "Psychologia społeczna",
                    "Psychologia dziecka"
                ],
                "occupancy": {
                    "noPlaces": 120,
                    "noCandidates": 100
                },
                "language": "Polski",
                "occupations": [
                    "Psychoterapeuta",
                    "Psycholog kliniczny"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Psychoterapia": 0.4,
                        "Psychologia kliniczna": 0.4,
                        "Metody badawcze": 0.2
                    },
                    "minThreshold": 90
                },
                "level": "Magisterskie",
                "tuition": 4800,
                "earningsMedian": 7500,
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
                                "Psychologia społeczna",
                                "Psychopatologia"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Psychologia dziecka",
                                "Psychoterapia"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Finanse i rachunkowość",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Studia licencjackie z finansów i rachunkowości.",
                "finalsSubjects": [
                    "Rachunkowość finansowa",
                    "Finanse przedsiębiorstw",
                    "Podatki"
                ],
                "interests": [
                    "Audyt",
                    "Controlling"
                ],
                "occupancy": {
                    "noPlaces": 180,
                    "noCandidates": 150
                },
                "language": "Polski",
                "occupations": [
                    "Analityk finansowy",
                    "Księgowy"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Rachunkowość finansowa": 0.4,
                        "Finanse przedsiębiorstw": 0.4,
                        "Podatki": 0.2
                    },
                    "minThreshold": 85
                },
                "level": "Licencjackie",
                "tuition": 3800,
                "earningsMedian": 6700,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do rachunkowości",
                                "Finanse przedsiębiorstw"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Rachunkowość finansowa",
                                "Podatki"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Audyt",
                                "Controlling"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Prawo",
                "category": "SOCIAL",
                "description": "Studia magisterskie z prawa.",
                "finalsSubjects": [
                    "Prawo cywilne",
                    "Prawo administracyjne",
                    "Prawo międzynarodowe"
                ],
                "interests": [
                    "Prawo handlowe",
                    "Prawo pracy"
                ],
                "occupancy": {
                    "noPlaces": 150,
                    "noCandidates": 120
                },
                "language": "Polski",
                "occupations": [
                    "Adwokat",
                    "Radca prawny"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Prawo cywilne": 0.4,
                        "Prawo administracyjne": 0.4,
                        "Prawo międzynarodowe": 0.2
                    },
                    "minThreshold": 90
                },
                "level": "Magisterskie",
                "tuition": 4800,
                "earningsMedian": 7500,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do prawa",
                                "Prawo cywilne"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Prawo administracyjne",
                                "Prawo międzynarodowe"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Prawo handlowe",
                                "Prawo pracy"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Architektura",
                "category": "ENGINEERING",
                "description": "Studia magisterskie z architektury.",
                "finalsSubjects": [
                    "Historia architektury",
                    "Projektowanie urbanistyczne",
                    "Konstrukcje budowlane"
                ],
                "interests": [
                    "Architektura krajobrazu",
                    "Architektura wnętrz"
                ],
                "occupancy": {
                    "noPlaces": 100,
                    "noCandidates": 80
                },
                "language": "Polski",
                "occupations": [
                    "Architekt",
                    "Urbanista"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Historia architektury": 0.4,
                        "Projektowanie urbanistyczne": 0.4,
                        "Konstrukcje budowlane": 0.2
                    },
                    "minThreshold": 90
                },
                "level": "Magisterskie",
                "tuition": 5000,
                "earningsMedian": 8000,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do architektury",
                                "Historia architektury"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Projektowanie urbanistyczne",
                                "Architektura krajobrazu"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Konstrukcje budowlane",
                                "Architektura wnętrz"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Ekonomia",
                "category": "BUSINESS_AND_ECONOMICS",
                "description": "Studia licencjackie z ekonomii.",
                "finalsSubjects": [
                    "Mikroekonomia",
                    "Makroekonomia",
                    "Ekonometria"
                ],
                "interests": [
                    "Polityka gospodarcza",
                    "Rynki finansowe"
                ],
                "occupancy": {
                    "noPlaces": 200,
                    "noCandidates": 180
                },
                "language": "Polski",
                "occupations": [
                    "Ekonomista",
                    "Analityk rynków finansowych"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "Mikroekonomia": 0.4,
                        "Makroekonomia": 0.4,
                        "Ekonometria": 0.2
                    },
                    "minThreshold": 85
                },
                "level": "Licencjackie",
                "tuition": 3800,
                "earningsMedian": 6700,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do ekonomii",
                                "Mikroekonomia"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Makroekonomia",
                                "Rynki finansowe"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Polityka gospodarcza",
                                "Ekonometria"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PRIVATE",
        "address": {
            "city": "Dąbrowa Górnicza",
            "street": "ul. Cieplaka",
            "buildingNumber": "15"
        },
        "coordinates": {
            "latitude": 50.3371,
            "longitude": 19.2176
        },
        "amenities": [
            {
                "name": "Studencka kafeteria",
                "type": "RESTAURANT",
                "distance": 100
            },
            {
                "name": "Laboratoria naukowe",
                "type": "EDUCATIONAL",
                "distance": 150
            },
            {
                "name": "Biblioteka",
                "type": "EDUCATIONAL",
                "distance": 120
            }
        ],
        "accessibilitiesForDisabled": [
        ],
        "clubs": [
            {
                "name": "Koło Naukowe Informatyki",
                "description": "Organizacja studencka dla miłośników informatyki."
            },
            {
                "name": "Koło Naukowe Psychologii",
                "description": "Organizacja studencka dla miłośników psychologii."
            },
            {
                "name": "Koło Naukowe Ekonomii",
                "description": "Organizacja studencka dla miłośników ekonomii."
            },
            {
                "name": "Koło Naukowe Prawa",
                "description": "Organizacja studencka dla miłośników prawa."
            },
            {
                "name": "Koło Naukowe Architektury",
                "description": "Organizacja studencka dla miłośników architektury."
            }
        ],
        "siteURL": "https://www.wsb.pl/dabrowa-gornicza/",
        "scholarships": [
            "Stypendium za wyniki w nauce",
            "Stypendium sportowe"
        ]
    },
    {
        "name": "Akademia Kultury Społecznej i Medialnej",
        "rating": 41.4,
        "photoUrl": "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/WSKSiM_w_Toruniu7.jpg/1200px-WSKSiM_w_Toruniu7.jpg",
        "courseDegrees": [
            {
                "name": "Dziennikarstwo",
                "category": "HUMANISTIC",
                "description": "Studiuj dziennikarstwo na Akademii Kultury Społecznej i Medialnej.",
                "finalsSubjects": [
                    "Teoria Komunikacji Medialnej",
                    "Reportaż Telewizyjny",
                    "Etyka Dziennikarska"
                ],
                "interests": [
                    "Dziennikarstwo Śledcze",
                    "Dziennikarstwo Obrazkowe"
                ],
                "occupancy": {
                    "noPlaces": 80,
                    "noCandidates": 60
                },
                "language": "Polski",
                "occupations": [
                    "Dziennikarz Telewizyjny",
                    "Redaktor Gazety",
                    "Reporter Śledczy"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "teoria_komunikacji": 0.5,
                        "etyka_dziennikarska": 0.3,
                        "angielski": 0.2
                    },
                    "minThreshold": 85
                },
                "level": "1",
                "tuition": 1900,
                "earningsMedian": 7600,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Wprowadzenie do dziennikarstwa",
                                "Podstawy teorii komunikacji medialnej"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Reportaż telewizyjny",
                                "Etyka dziennikarska"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Dziennikarstwo śledcze",
                                "Dziennikarstwo obrazkowe"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Kulturoznawstwo",
                "category": "HUMANISTIC",
                "description": "Zajmuj się kulturoznawstwem na Akademii Kultury Społecznej i Medialnej.",
                "finalsSubjects": [
                    "Teoria Kultury",
                    "Socjologia Kultury",
                    "Media a Kultura Współczesna"
                ],
                "interests": [
                    "Kultura Popularna",
                    "Kultura Młodzieżowa"
                ],
                "occupancy": {
                    "noPlaces": 70,
                    "noCandidates": 50
                },
                "language": "Polski",
                "occupations": [
                    "Kulturoznawca",
                    "Kurator Wystaw",
                    "Specjalista ds. Kultury"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "teoria_kultury": 0.6,
                        "socjologia_kultury": 0.4
                    },
                    "minThreshold": 80
                },
                "level": "1inz",
                "tuition": 2000,
                "earningsMedian": 7400,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Teoria kultury",
                                "Wprowadzenie do socjologii kultury"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Socjologia kultury",
                                "Media a kultura współczesna"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Kultura popularna",
                                "Kultura młodzieżowa"
                            ]
                        }
                    ]
                }
            },
            {
                "name": "Socjologia Komunikacji Społecznej",
                "category": "SOCIAL",
                "description": "Studiuj socjologię komunikacji społecznej na Akademii Kultury Społecznej i Medialnej.",
                "finalsSubjects": [
                    "Teorie Komunikacji Społecznej",
                    "Badania Opinii Publicznej",
                    "Psychologia Społeczna"
                ],
                "interests": [
                    "Komunikacja Interpersonalna",
                    "Marketing Społeczny"
                ],
                "occupancy": {
                    "noPlaces": 60,
                    "noCandidates": 40
                },
                "language": "Polski",
                "occupations": [
                    "Analityk Rynku",
                    "Specjalista ds. Komunikacji Społecznej",
                    "Badacz Opinii Publicznej"
                ],
                "examThreshold": {
                    "subjectToWeightMap": {
                        "teorie_komunikacji_spolecznej": 0.5,
                        "psychologia_spoleczna": 0.3,
                        "angielski": 0.2
                    },
                    "minThreshold": 82
                },
                "level": "2",
                "tuition": 2100,
                "earningsMedian": 7700,
                "syllabus": {
                    "semesters": [
                        {
                            "ordinal": 1,
                            "subjects": [
                                "Teorie komunikacji społecznej",
                                "Wprowadzenie do badań opinii publicznej"
                            ]
                        },
                        {
                            "ordinal": 2,
                            "subjects": [
                                "Badania opinii publicznej",
                                "Psychologia społeczna"
                            ]
                        },
                        {
                            "ordinal": 3,
                            "subjects": [
                                "Komunikacja interpersonalna",
                                "Marketing społeczny"
                            ]
                        }
                    ]
                }
            }
        ],
        "type": "PRIVATE",
        "address": {
            "city": "Toruń",
            "street": "Droga Starotoruńska",
            "buildingNumber": "3"
        },
        "coordinates": {
            "latitude": 53.0184784,
            "longitude": 18.5136364
        },
        "amenities": [
            {
                "name": "Kawiarnia Artystyczna",
                "type": "RESTAURANT",
                "distance": 120
            },
            {
                "name": "Stowarzyszenie Kulturoznawców",
                "type": "EDUCATIONAL",
                "distance": 90
            },
            {
                "name": "Klub Taneczny",
                "type": "RECREATION",
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
                "name": "Debata Akademicka",
                "description": "Spotkania studenckie poświęcone różnorodnym tematom kulturowym."
            },
            {
                "name": "Studenckie Koło Fotograficzne",
                "description": "Wspólne wyjścia i projekty fotograficzne."
            }
        ],
        "siteURL": "https://www.aksim.edu.pl/",
        "scholarships": [
            "Stypendium naukowe",
            "Stypendium artystyczne"
        ]
    }
]""".trimIndent()