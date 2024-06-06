


import React, { useState } from 'react';

const HistoryList = () => {
  const [list, setList] = useState([]);

  return (
    <div style={{ padding: 15, fontSize: 12, backgroundColor: 'white' }}>
      <h1>History</h1>
      Below we should display the list of previous calculations. Each time the user clicks = we should see a new entry.
      <br/>
      E.g. 12 + 4 = 16
      <ul>
        {list.map((item, index) => (
          <li key={index}>{item}</li>
        ))}
      </ul>
    </div>
  );
};

export default HistoryList;