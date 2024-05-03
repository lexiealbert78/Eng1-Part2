<?xml version="1.0" encoding="UTF-8"?>
<tileset version="1.10" tiledversion="1.10.2" name="goal" tilewidth="32" tileheight="32" tilecount="3" columns="3">
 <image source="../../../../goal.png" width="96" height="37"/>
 <tile id="0">
  <properties>
   <property name="blocked" type="bool" value="true"/>
  </properties>
  <objectgroup draworder="index" id="2">
   <object id="1" x="13" y="4" width="19" height="28"/>
  </objectgroup>
 </tile>
 <tile id="1">
  <properties>
   <property name="blocked" type="bool" value="true"/>
  </properties>
  <objectgroup draworder="index" id="2">
   <object id="1" x="0" y="5" width="32" height="27"/>
  </objectgroup>
 </tile>
 <tile id="2">
  <properties>
   <property name="blocked" type="bool" value="true"/>
  </properties>
  <objectgroup draworder="index" id="2">
   <object id="1" x="0" y="4" width="19" height="28">
    <properties>
     <property name="blocked" type="bool" value="true"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
</tileset>
