import React, { useState } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import './styles.css'; //

const DateTimePicker = () => {
  const [selectedDate, setSelectedDate] = useState(null);

  const handleDateChange = (date) => {
    setSelectedDate(date);
  };

  return (
    <div className="datetime-picker-container">
      <input
        type="text"
        className="date-input"
        value={selectedDate ? selectedDate.toLocaleString() : ''}
        placeholder="Selecione data e horário"
        readOnly
      />
      <DatePicker
        selected={selectedDate}
        onChange={handleDateChange}
        showTimeSelect
        dateFormat="Pp"
        placeholderText="Clique para escolher a data"
        customInput={
          <button className="open-calendar-button">Calendário</button>
        }
      />
    </div>
  );
};

export default DateTimePicker;
