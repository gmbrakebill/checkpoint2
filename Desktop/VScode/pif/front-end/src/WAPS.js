import React from 'react';

function WAPS(props)
{
    console.log(props);
    return(
        <div className = "airmen">
            <p>Airman ID: {props.id}</p>
            <p>Time in service: {String(props.time_in_service)} </p>
            <p>Time in grade: {String(props.time_in_grade)}</p> 
            <p>EPR DATA: {String(props.epr_data)}</p>
        </div>
    )
}
export default WAPS;