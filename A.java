# Psotgresql Packet Install
sonarqube(){
   
    echo -e "\n### ${SONARQUBE} Kurulumu ###"
    read -p "\nSonarQube İstiyor musunuz ? E/H? " sonarqubeResult
    if [[ $sonarqubeResult == "E" || $sonarqubeResult == "e"  ]]
    then
        echo -e "SonarQube Ekleniyor ... " 
         # Geri Sayım
        sudo ./countdown.sh
      
    else
        echo -e "SonarQube Kurulumu Yapılmadı!!!\n "   
    fi
}
sonarqube
