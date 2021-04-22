
//Tables in 'My Qualifications'
var gcses = {"Maths":"A*", "English Language":"B", "English Literature":"C", "Biology":"A", "Chemistry":"A", "Physics":"A", "History":"B", "Geography":"A", "Spanish":"A", "ICT":"A"};

for(index in gcses){
  tableGCSEs = document.getElementById("tableGCSEs");
  row = tableGCSEs.insertRow();
  cell1 = row.insertCell(0);
  cell2 = row.insertCell(1);

  cell1.innerHTML = index;
  cell2.innerHTML = gcses[index];
}

var aslevels = {"Maths":"A", "Physics":"B", "Further Maths":"B", "ICT":"B"};

for(index in aslevels){
  tableASLevels = document.getElementById("tableASLevels");
  row = tableASLevels.insertRow();
  cell1 = row.insertCell(0);
  cell2 = row.insertCell(1);

  cell1.innerHTML = index;
  cell2.innerHTML = aslevels[index];
}

var alevels = {"Maths":"A", "ICT":"C", "Physics":"D"};

for(index in alevels){
  tableALevels = document.getElementById("tableALevels");
  row = tableALevels.insertRow();
  cell1 = row.insertCell(0);
  cell2 = row.insertCell(1);

  cell1.innerHTML = index;
  cell2.innerHTML = alevels[index];
}

